package com.billie

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinKafkaApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinKafkaApplication>(*args)
}
