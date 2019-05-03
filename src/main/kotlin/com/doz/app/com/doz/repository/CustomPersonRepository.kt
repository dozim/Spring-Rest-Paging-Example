package com.doz.app.com.doz.repository

import com.doz.app.com.doz.model.Person

interface CustomPersonRepository {
    fun getPersonTestData(): List<Person>
}
