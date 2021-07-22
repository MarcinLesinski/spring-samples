package io.stud.forest.springsamples.fantasy_world.repositories

import io.stud.forest.springsamples.fantasy_world.model.Terrain
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TerrainsRepository {
    fun save(terrain: Terrain): Terrain
    fun saveAll(terrains: Iterable<Terrain>): Iterable<Terrain>
}

@Repository
interface TerrainsBareRepository: JpaRepository<Terrain, Long>, TerrainsRepository {
    override fun <S : Terrain?> saveAll(entities: MutableIterable<S>): MutableList<S>
}