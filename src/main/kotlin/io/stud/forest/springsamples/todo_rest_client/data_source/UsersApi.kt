package io.stud.forest.springsamples.todo_rest_client.data_source

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.stud.forest.springsamples.todo_rest_client.model.Task
import io.stud.forest.springsamples.todo_rest_client.model.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface UsersApi {
    @GET("/users")
    fun users(): Observable<List<User>>

    @GET("/users/{userId}/todos")
    fun tasksByUser(@Path("userId") userId: Int): Observable<List<Task>>

    @GET("/todos")
    fun tasksByUser2ndWay(@Query("userId") userId: Int): Observable<List<Task>>
}