package io.stud.forest.springsamples

import io.stud.forest.springsamples.properties.SettingsToTest
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(SettingsToTest::class)
class SpringSamplesApplication

fun main(args: Array<String>) {
	runApplication<SpringSamplesApplication>(*args)
}
