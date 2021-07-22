package io.stud.forest.springsamples.fantasy_world.repositories

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.assertj.core.api.Assertions.assertThat
import org.springframework.test.context.junit.jupiter.SpringExtension
import io.stud.forest.springsamples.fantasy_world.model.Character
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource

//@ExtendWith(SpringExtension::class)
//@AutoConfigureMockMvc
//@ContextConfiguration(classes = [CharactersBareRepository::class])
//@WebMvcTest
@SpringBootTest
class CharactersRepositoryTests
{

//    lateinit var charactersRepository: CharactersBareRepository

    @Test
    fun `q`() {
//        val newCharacter = Character()
//        val character = charactersRepository.save(newCharacter)
//        val savedCharacter: Character? = charactersRepository.findByIdOrNull(character.id)
//
//        assertThat(character).isEqualTo(savedCharacter)
    }
}