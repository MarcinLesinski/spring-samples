package io.stud.forest.springsamples.mockito

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito.*
import org.mockito.stubbing.Answer
import strikt.api.expect

class WhenFunctionTests {

    private lateinit var subject: SomeClass

    @BeforeEach
    fun beforeEach() {
        subject = mock(SomeClass::class.java)
    }

    @Test
    fun `configure simple return behavior`() {
        `when`(subject.function(anyInt()))
                .thenReturn(5)

        val actual = subject.function(7)
        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `configure simple return behavior - alternative way`() {
        doReturn(5).`when`(subject).function(anyInt())

        val actual = subject.function(7)
        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `configure mock to throw an exception on all method call`() {
        doThrow(IllegalStateException::class.java).`when`(subject).function(anyInt())

        assertThrows<IllegalStateException> {
            subject.function(123)
        }
    }

    @Test
    fun `configure void return type method to throw an exception`() {
        doThrow(NullPointerException::class.java).`when`(subject).getter()

        assertThrows<NullPointerException> {
            subject.getter()
        }
    }

    @Test
    fun `configure the behavior of multiple calls`() {
        `when`(subject.function(anyInt()))
                .thenReturn(8)
                .thenThrow(IllegalStateException::class.java)

        val actual = subject.function(anyInt())
        assertThat(actual).isEqualTo(8)
        assertThrows<IllegalStateException> {
            subject.function(anyInt())
        }
    }

    @Test
    fun `configure the behavior of a spy`() {
        val instance = SomeClass()
        val spy = spy(instance)

        doThrow(NullPointerException::class.java).`when`(spy).getter()

        assertThrows<NullPointerException> {
            spy.getter()
        }
    }

    @Test
    fun `configure mock to call real method`() {
        doCallRealMethod().`when`(subject).function(anyInt())

        assertThat(subject.function(8)).isEqualTo(8)
    }

    @Test
    fun `configure method to return custom value`() {
        doAnswer{ invocation ->
            val argument = invocation.getArgument<Int>(0)
            return@doAnswer argument * argument
        }.`when`(subject).function(anyInt())

        val answer = subject.function(8)

        assertThat(answer).isEqualTo(64)
    }
}

