package io.stud.forest.springsamples.fantasy_world.model

import javax.persistence.*

@Entity
@Table(name = "characters")
class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column(name = "name")
    var name : String = ""


    @OneToOne
    @JoinColumn(name = "character_motto_id")
    var motto: CharacterMotto = CharacterMotto.empty()
}