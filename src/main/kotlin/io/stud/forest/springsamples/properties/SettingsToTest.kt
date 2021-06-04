package io.stud.forest.springsamples.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Configuration

@ConfigurationProperties("properties.settings-to-test")
@ConstructorBinding
data class SettingsToTest(
        val number: Int,
        val text: String,
        val truth: Boolean,
        val record: Record
)

data class Record(
        val field1: Int,
        val field2: Int,
        val field3: Int,
)