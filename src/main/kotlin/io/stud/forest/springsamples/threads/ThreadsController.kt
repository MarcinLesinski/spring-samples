package io.stud.forest.springsamples.threads

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/thread")
class ThreadsController
@Autowired
constructor(
        private val deadlockService: DeadlockService
)
{
    @GetMapping("/deadlock")
    fun deadlock() {
        deadlockService.createDeadlockedThreads()
    }

}