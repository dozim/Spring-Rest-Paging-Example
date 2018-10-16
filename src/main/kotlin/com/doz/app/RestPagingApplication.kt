package com.doz.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestPagingApplication

fun main(args: Array<String>) {
    runApplication<RestPagingApplication>(*args)
}
