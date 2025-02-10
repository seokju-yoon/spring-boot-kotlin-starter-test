package com.billie.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "aws.dynamodb")
class DynamoDBProperties {
    var endpoint: String? = null
    var region: String? = null
    var accessKey : String? = null
    var secretKey: String? = null
}