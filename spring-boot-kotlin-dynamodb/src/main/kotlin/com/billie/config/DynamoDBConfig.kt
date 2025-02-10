package com.billie.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.net.URI

@Configuration
class DynamoDBConfig(
    private val dynamoDBProperties: DynamoDBProperties
) {

    @Bean
    fun dynamoDbClient(): DynamoDbClient =
        DynamoDbClient.builder().apply {
            endpointOverride(dynamoDBProperties.endpoint?.let { URI.create(it) })
            region(Region.of(dynamoDBProperties.region))
            credentialsProvider(
                StaticCredentialsProvider.create(
                    AwsBasicCredentials.create(
                        dynamoDBProperties.accessKey,
                        dynamoDBProperties.secretKey
                    )
                )
            )
        }.build()

    @Bean
    fun dynamoDbEnhancedClient(dynamoDbClient: DynamoDbClient): DynamoDbEnhancedClient =
        DynamoDbEnhancedClient.builder()
            .dynamoDbClient(dynamoDbClient)
            .build()
}