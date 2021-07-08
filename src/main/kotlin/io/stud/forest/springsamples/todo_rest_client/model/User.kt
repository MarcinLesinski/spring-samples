package io.stud.forest.springsamples.todo_rest_client.model

import com.google.gson.annotations.SerializedName

data class User(
        val id: Int
) {
    var name: String? = null
    var userName: String? = null
    var email: String? = null
    var phone: String? = null
    var website: String? = null

    @SerializedName("tasks")
    var tasks: List<Task> = listOf()

//    val tasks: List<Task>
//        get() = _tasks!!
}
