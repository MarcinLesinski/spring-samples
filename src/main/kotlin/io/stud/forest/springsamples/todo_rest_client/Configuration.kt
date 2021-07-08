package io.stud.forest.springsamples.todo_rest_client

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.stud.forest.springsamples.todo_rest_client.data_source.UsersApi
import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Configuration
class Configuration {
    @Bean
    fun retrofit(): Retrofit {
        val httpClient = OkHttpClient.Builder().build()
        return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(httpClient)
                .build()
    }

    @Bean
    fun usersApi(retrofit: Retrofit): UsersApi {
        return retrofit.create(UsersApi::class.java)
    }
}