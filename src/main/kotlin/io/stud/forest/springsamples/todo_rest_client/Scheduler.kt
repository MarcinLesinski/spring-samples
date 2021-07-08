package io.stud.forest.springsamples.todo_rest_client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Scheduler
@Autowired
constructor(
        private val todoService: TodoService
) {
    @Scheduled(fixedDelay = 5 * 1000)
    fun run() {
        todoService.printTodoListForAllUsers()
    }
}
