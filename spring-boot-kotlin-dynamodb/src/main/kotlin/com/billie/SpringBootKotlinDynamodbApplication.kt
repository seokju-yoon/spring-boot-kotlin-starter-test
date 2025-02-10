package com.billie

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinDynamodbApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinDynamodbApplication>(*args)
}
