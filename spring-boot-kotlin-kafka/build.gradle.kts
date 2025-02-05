plugins {
    id("com.github.davidmc24.gradle.plugin.avro") version "1.9.1"
}

repositories {
    maven {
        url = uri("https://packages.confluent.io/maven/")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("io.confluent:kafka-avro-serializer:7.8.0")

    testImplementation("org.springframework.kafka:spring-kafka-test")
}

sourceSets {
    main {
        kotlin.srcDir(layout.buildDirectory.dir("generated-main-avro-java"))
    }
}