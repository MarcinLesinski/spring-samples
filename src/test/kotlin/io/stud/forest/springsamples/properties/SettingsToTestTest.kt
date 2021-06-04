package io.stud.forest.springsamples.properties

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import strikt.api.expectThat
import strikt.assertions.isEqualTo

@ExtendWith(SpringExtension::class)
@EnableConfigurationProperties(value = [SettingsToTest::class])
@TestPropertySource("/application.yml")
@ContextConfiguration(initializers = [ConfigDataApplicationContextInitializer::class])
internal class SettingsToTestTest
@Autowired
constructor(
        private val settings: SettingsToTest
){
    @Test
    fun `inject nested properties if exist`(){
        val expected = SettingsToTest(1, "lorem ipsum dolor", false, Record(1, 2, 3))

        expectThat(settings)
                .isEqualTo(expected)
    }
}