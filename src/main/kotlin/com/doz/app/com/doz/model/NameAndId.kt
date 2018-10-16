package com.doz.app.com.doz.model

import org.springframework.data.rest.core.config.Projection

@Projection(name = "nameAndId", types = [Person::class])
interface NameAndId {
    fun getName(): String
    fun getId(): Long
}