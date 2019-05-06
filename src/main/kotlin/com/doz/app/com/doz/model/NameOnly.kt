package com.doz.app.com.doz.model

import org.springframework.data.rest.core.config.Projection

@Projection(name = "nameOnly", types = [Company::class])
interface NameOnly {
    fun getName(): String;
}
