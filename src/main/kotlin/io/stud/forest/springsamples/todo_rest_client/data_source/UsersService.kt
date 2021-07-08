package io.stud.forest.springsamples.todo_rest_client.data_source

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.Consumer
import io.stud.forest.springsamples.todo_rest_client.Printer
import io.stud.forest.springsamples.todo_rest_client.model.User
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsersService
@Autowired
constructor(
        private val api: UsersApi
) {
    companion object {
        private val log = LoggerFactory.getLogger(Printer::class.java)
    }

    fun users(): Single<List<User>> {
        return api
                .users()
                .flatMapIterable { it }
                .flatMap { user ->
                    api
                            .tasksByUser(user.id)
                            .flatMap {
                                user.tasks = it;
                                Observable.just(user)
                            }
                }.toList()
    }
}