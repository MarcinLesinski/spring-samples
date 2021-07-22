package io.stud.forest.springsamples.todo_rest_client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
@ConditionalOnProperty(value = ["properties.todo_rest_client_enabled"] , havingValue = "true", matchIfMissing = false)
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
