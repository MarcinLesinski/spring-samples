package io.stud.forest.springsamples.todo_rest_client

import io.stud.forest.springsamples.todo_rest_client.model.Task
import io.stud.forest.springsamples.todo_rest_client.model.User
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.text.MessageFormat
import java.util.function.Consumer

@Service
class Printer {
    fun print(users: List<User>) {
        users.forEach(Consumer<User> { user: User -> printOneUserWithTasks(user) })
    }

    private fun printOneUserWithTasks(user: User) {
        printUser(user)
        printTasks(user)
        printSeparator()
    }

    private fun printUser(user: User) {
        val userPresentation = presentUser(user)
        print(userPresentation)
    }

    private fun printTasks(user: User) {
        user
                .tasks
                .map {presentTask(it)}
                .forEach(this::print)
    }

    private fun printSeparator() {
        print("")
    }

    private fun presentUser(user: User): String {
        val userName = user.userName
        val id = user.id
        return MessageFormat.format("User #{0}({1})", id, userName)
    }

    private fun presentTask(task: Task): String {
        val completedMark = if (task.completed) "*" else " "
        val title = task.title
        return MessageFormat.format("\t [{0}] task: {1}", completedMark, title)
    }

    private fun print(text: String) {
        log.info(text)
    }

    companion object {
        private val log = LoggerFactory.getLogger(Printer::class.java)
    }
}