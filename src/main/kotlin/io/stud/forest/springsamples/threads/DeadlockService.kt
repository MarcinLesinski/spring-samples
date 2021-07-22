package io.stud.forest.springsamples.threads

import org.springframework.stereotype.Service

@Service
class DeadlockService {

    fun createDeadlockedThreads() {
        val objectA: Any = Any()
        val objectB: Any = Any()


        val t1 = Thread {
            synchronized(objectA) {
                println("A is waiting for B")
                synchronized(objectB) {
                    println("A has B")
                }
            }
        }
        val t2 = Thread {
            synchronized(objectB) {
                println("B is waiting for A")
                synchronized(objectA) {
                    println("A has B")
                }
            }
        }

        t1.start()
        t2.start()

    }
}