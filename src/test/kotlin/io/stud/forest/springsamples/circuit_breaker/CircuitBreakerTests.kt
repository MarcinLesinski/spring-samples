package io.stud.forest.springsamples.circuit_breaker


import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory
import org.springframework.test.context.junit.jupiter.SpringExtension

import java.util.function.Supplier

//@ExtendWith(SpringExtension::class)
class CircuitBreakerTests {

    private var service: SampleService = object : SampleService {
        override fun process(i: Int): Int {
            return i
        }
    }

    @BeforeEach
    fun setUp() {
        service = mock(SampleService::class.java)
    }

    @ParameterizedTest
    @ValueSource(ints = [2, 3, 4, 5, 6, 7])
    fun `should open state after given number of tries`(numberOfTries: Int) {
//        val range = 0..9
//        val config = CircuitBreakerConfig.custom()
//                .ringBufferSizeInClosedState(numberOfTries)
//                .build()
//
//         val f = cbf.create("cbf")
//        val serviceSupplier = `decorate service with circuit breaker`(service, config)
//
//        doThrow(NullPointerException::class.java).`when`(service).process(anyInt())
//
//        for (i in range) {
//            try {
//                serviceSupplier.get()
//            } catch (ignore: Exception) {
//            }
//        }
//
//        verify(service, times(numberOfTries)).process(anyInt())
//        for (i in range) {
//            if (i < numberOfTries)
//                verify(service).process(i)
//            else
//                verify(service, never()).process(i)
//        }
    }

    interface SampleService {
        fun process(i: Int): Int
    }

//    private fun `decorate service with circuit breaker`(service: SampleService, config: CircuitBreakerConfig): Supplier<Int> {
//        val registry = CircuitBreakerRegistry.of(config)
//        val circuitBreaker = registry.circuitBreaker("name")
//
//            CircuitBreaker.decorateFunction<Int, Int>(circuitBreaker, service::process)
//        return Decorators
//                .ofSupplier { service.process(1) }
//                .withCircuitBreaker(circuitBreaker)
//                .withFallback { _: Throwable ->
//                    println("fallback")
//                    6
//                }.decorate()
//    }
}