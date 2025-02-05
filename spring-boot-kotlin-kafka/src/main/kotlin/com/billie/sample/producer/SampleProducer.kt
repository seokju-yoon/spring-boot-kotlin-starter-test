package com.billie.sample.producer

import com.iicombined.atiissu.oms.sample.kafka.message.SampleMessage
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class SampleProducer(
    private val kafkaTemplate: KafkaTemplate<String, SampleMessage>,
    @Value("\${kafka.topic.sample.name}")
    private val topicName: String
) {

    fun send(
        message: SampleMessage
    ) {
        kafkaTemplate.send(topicName, message.id.toString(), message)
    }
}