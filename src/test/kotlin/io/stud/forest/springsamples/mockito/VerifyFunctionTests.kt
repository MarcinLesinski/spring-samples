package io.stud.forest.springsamples.mockito

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.mockito.InOrder
import org.mockito.Mockito.*


class VerifyFunctionTests {

    @Test
    fun `verify simple invocation`(){
        val mock = mock(SomeClass::class.java)
        mock.getter()
        verify(mock).getter()
    }

    @Test
    fun `verify number of invocations`(){
        val mock = mock(SomeClass::class.java)
        mock.getter()
        mock.getter()
        mock.getter()
        verify(mock, times(3)).getter()
    }

    @Test
    fun `verify no interactions`(){
        val mock = mock(SomeClass::class.java)
        verify(mock, never()).getter()
        // or
         verify(mock, times(0)).getter()
    }

    @Test
    fun `verify no interactions with mock`(){
        val mock = mock(SomeClass::class.java)
        verifyNoInteractions(mock)
    }

    @Test
    fun `verify order of interactions`(){
        val mock = mock(SomeClass::class.java)

        mock.getter()
        mock.function(1)
        mock.getter()

        val inOrder: InOrder =  inOrder(mock)
        inOrder.verify(mock).getter()
        inOrder.verify(mock).function(anyInt());
        inOrder.verify(mock).getter();
    }

    @Test
    fun `verify interaction has occurred at least or at most`(){
        val mock = mock(SomeClass::class.java)

        mock.getter()
        mock.getter()
        mock.getter()

        verify(mock, atLeast(1)).getter()
        verify(mock, atMost(5)).getter()
    }

    @Test
    fun `verify interaction with exact argument`(){
        val mock = mock(SomeClass::class.java)

        mock.function(435)

        verify(mock).function(435)
    }

    @AfterEach
    fun validate() {
        validateMockitoUsage()
//        verifyNoMoreInteractions(mock)
    }
}