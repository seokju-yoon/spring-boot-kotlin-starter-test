package com.billie.sample

import com.billie.sample.producer.SampleProducer
import com.iicombined.atiissu.oms.sample.kafka.message.SampleMessage
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/samples")
class SampleController(
    private val sampleProducer: SampleProducer
) {

    @PostMapping("/send")
    fun sendMessage() {
        val message = SampleMessage.newBuilder()
            .setId(1L)
            .setValue("test message")
            .build()

        sampleProducer.send(message)
    }
}