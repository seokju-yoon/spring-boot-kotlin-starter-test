package com.billie.sample.consumer

import com.iicombined.atiissu.oms.sample.kafka.message.SampleMessage
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class SampleConsumer {

    private val log = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["\${kafka.topic.sample.name}"])
    fun consumeSample(consumerRecord: ConsumerRecord<String, SampleMessage>) {
        consumerRecord.value()?.let { message ->
            log.info("consume sample message: $message")
        }
    }
}