package com.billie.config.kafka

import org.apache.kafka.common.errors.SerializationException
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.listener.DefaultErrorHandler
import org.springframework.kafka.support.serializer.DeserializationException
import org.springframework.util.backoff.FixedBackOff

@Configuration
class ConsumerConfig {

    private val log = LoggerFactory.getLogger(javaClass)

    @Bean
    fun <V> kafkaListenerContainerFactory(
        consumerFactory: ConsumerFactory<String, V>
    ): ConcurrentKafkaListenerContainerFactory<String, V> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, V>()
        factory.consumerFactory = consumerFactory

        val errorHandler = DefaultErrorHandler(
            { record, exception ->
                log.error(
                    "Error processing record: topic={}, partition={}, offset={}, key={}, value={}",
                    record.topic(),
                    record.partition(),
                    record.offset(),
                    record.key(),
                    record.value(),
                    exception
                )
            },
            FixedBackOff(1000L, 2L)
        )

        errorHandler.setClassifications(emptyMap(), false)
        errorHandler.addNotRetryableExceptions(
            DeserializationException::class.java,
            SerializationException::class.java,
            IllegalArgumentException::class.java
        )

        factory.setCommonErrorHandler(errorHandler)

        return factory
    }
}