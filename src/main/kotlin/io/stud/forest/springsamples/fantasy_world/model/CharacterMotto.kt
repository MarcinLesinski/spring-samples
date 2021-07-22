package io.stud.forest.springsamples.fantasy_world.model

import javax.persistence.*

@Entity
@Table(name = "character_mottos")
class CharacterMotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column(name = "text")
    var text: String = ""

    companion object {
        fun empty(): CharacterMotto{
            val result = CharacterMotto()
            result.text = ""
            return result
        }
    }
}