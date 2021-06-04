package io.stud.forest.springsamples.properties


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import strikt.api.expectThat
import strikt.assertions.isEqualTo



@ExtendWith(SpringExtension::class)
/// its needed to works with yml properties
@ContextConfiguration(initializers = [ConfigDataApplicationContextInitializer::class])
@TestPropertySource("/application.yml")
class PropertiesTests(
        @Value("\${properties.constructor-injected-property}") val constructorProperty: String
) {

    @Value("\${properties.field-injected-property}")
    val fieldProperty: String = ""

    @Test
    fun `inject property value by field if it exists` (){
        println(fieldProperty)
        expectThat(fieldProperty)
                .isEqualTo("field property")
    }

    @Test
    fun `inject property value by constructor if it exists` (){
        expectThat(constructorProperty)
                .isEqualTo("constructor property")
    }

    @Test
    fun `get property by Environment if exists`(@Autowired env: Environment){
        val propertyValue = env.getProperty("property-1")
        expectThat(propertyValue)
                .isEqualTo("property 1 value")
    }

}

