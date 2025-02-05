package com.billie

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinJpaApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinJpaApplication>(*args)
}
