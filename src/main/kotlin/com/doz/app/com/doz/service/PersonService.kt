package com.doz.app.com.doz.service

import com.doz.app.com.doz.model.NameAndId
import com.doz.app.com.doz.model.Person
import com.doz.app.com.doz.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@ConditionalOnProperty("repo.active")
@Service
class PersonService (@Autowired private val personRepository: PersonRepository){


    fun save(person: Person): Person {
        return personRepository.save(person)
    }

    fun get(pageable: Pageable): Page<Person> {
        return personRepository.findAll(pageable)
    }

    fun getPersons(pageable: Pageable): Page<Person> {
        return personRepository.findAllPersons(pageable)
    }

    fun getPersonsNameAndId(pageable: Pageable) : Page<NameAndId> {
        return personRepository.findByName(pageable)
    }
}