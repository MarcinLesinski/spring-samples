package io.stud.forest.springsamples.fantasy_world.model

import javax.persistence.*

@Entity
@Table(name = "terrains")
class Terrain() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column(name = "name")
    var name: String = ""

    constructor(name: String) : this() {
        this.name = name
    }
}