package io.stud.forest.springsamples

import io.stud.forest.springsamples.properties.SettingsToTest
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@SpringBootApplication
@EnableScheduling
//@ComponentScan(basePackages = ["io.stud.forest.todo_rest_client"])
@EnableConfigurationProperties(SettingsToTest::class)
class SpringSamplesApplication

fun main(args: Array<String>) {
	runApplication<SpringSamplesApplication>(*args)
}
