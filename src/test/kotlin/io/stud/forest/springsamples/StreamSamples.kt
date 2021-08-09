package io.stud.forest.springsamples

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StreamSamples {

    private val numbers = listOf<Int>(1, 2, 3, 4, 5)
    private val objects = numbers.map { TestClass(it) }
    private val arrays = List(3){ numbers }

    @Test
    fun `map sample`() {
        val actual = numbers.map { it + 1 }

        assertThat(actual).isEqualTo(listOf(2, 3, 4, 5, 6))
    }


    @Test
    fun `filter sample`() {
        val actual = numbers.filter(isEven)

        assertThat(actual).isEqualTo(listOf(2, 4))
    }


    @Test
    fun `min sample`() {
        val actual = numbers.minOrNull()
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun `minBy sample`() {
        val actual = objects.minByOrNull { it.number }
        assertThat(actual).isEqualTo(TestClass(1))
    }

    @Test
    fun `find sample`() {
        val actual = numbers.find(isEven)
        assertThat(actual).isEqualTo(2)
    }


    private val isEven: (Int) -> Boolean = { i -> i.rem(2) == 0 }
    private val isOdd: (Int) -> Boolean = { i -> isEven(i).not() }
}

class TestClass() {
    var number = 0

    constructor (number: Int) : this() {
        this.number = number
    }

    fun inc() {
        number += 1
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TestClass

        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        return number
    }

}