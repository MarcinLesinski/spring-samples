package io.stud.forest.springsamples.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler

@Configuration
class SchedulerConfig {
    @Bean
    // Schedulers fix
    fun taskScheduler(): ThreadPoolTaskScheduler? {
        val taskScheduler = ThreadPoolTaskScheduler()
        taskScheduler.poolSize = 55
        return taskScheduler
    }
}