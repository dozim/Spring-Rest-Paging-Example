package com.doz.app.com.doz.service

import com.doz.app.com.doz.model.NameAndId
import com.doz.app.com.doz.model.Person
import com.doz.app.com.doz.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.stereotype.Service

@Service
class PersonService(@Autowired private val personRepository: PersonRepository) {

    fun save(person: Person): Person = personRepository.save(person)

    fun getAll(pageable: Pageable): Page<Person> = personRepository.findAll(pageable)

    fun getPersons(pageable: Pageable): Page<Person> = personRepository.findAllNative(pageable)

    fun getPersonsNameAndId(pageable: Pageable): Page<NameAndId> = personRepository.findAllAsNameAndId(pageable)

    fun findPersonByNameIsNotNull(pageable: Pageable): Slice<Person> = personRepository.findPersonByNameIsNotNull(pageable)

    fun getPersonsByForenameAndName(forename: String, name: String, pageable: Pageable) = personRepository.findByForenameAndName(forename, name, pageable)
}
