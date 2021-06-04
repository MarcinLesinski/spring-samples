package io.stud.forest.springsamples.properties

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/properties")
class PropertiesController(
        @Value("\${properties.constructor-injected-property}") private val constructorProperty: String,
        private val settings: SettingsToTest
) {


    @Value("\${properties.field-injected-property}")
    val fieldProperty: String = ""

    @GetMapping("/test")
    fun getSomeProperties(): String {
        return """
            $fieldProperty
            $constructorProperty
            ${settings.number}
        """.trimIndent()
    }


}