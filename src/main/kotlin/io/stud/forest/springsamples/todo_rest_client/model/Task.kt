package io.stud.forest.springsamples.todo_rest_client.model

data class Task(
        val id: Int
) {
    var userId: Int? = null
    var title: String? = null
    var completed: Boolean = false
}
