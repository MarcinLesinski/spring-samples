package io.stud.forest.springsamples.fantasy_world.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import io.stud.forest.springsamples.fantasy_world.model.Character
import java.util.*

interface CharactersRepository {
    fun save(character: Character): Character
    fun findById(id: Long): Optional<Character>
//    fun findByIdOrNull(id: Long): Character? = findById(id).orElse(null)
}

@Repository
interface CharactersBareRepository:  JpaRepository<Character, Long>, CharactersRepository {
//    override fun findByIdOrNull(id: Long): Character? = findById(id).orElse(null)
}