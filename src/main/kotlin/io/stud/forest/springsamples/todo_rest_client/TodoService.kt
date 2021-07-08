package io.stud.forest.springsamples.todo_rest_client

import io.stud.forest.springsamples.todo_rest_client.data_source.UsersService
import io.stud.forest.springsamples.todo_rest_client.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory
import org.springframework.stereotype.Service

@Service
class TodoService
@Autowired
constructor(
        private val userService: UsersService,
        private val printer: Printer) {

    @Autowired
    lateinit var cbf: Resilience4JCircuitBreakerFactory

    var lastState: MutableList<User> = mutableListOf()

    fun printTodoListForAllUsers() {
        val usersObservable = userService.users()
        usersObservable.subscribe(
                {
                    lastState.clear()
                    lastState.addAll(it)
                    printer.print(lastState)
                },
                {
                    printer.print(lastState)
                }
        )

    }
}
