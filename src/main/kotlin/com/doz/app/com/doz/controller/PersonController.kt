package com.doz.app.com.doz.controller

import com.doz.app.com.doz.model.NameAndId
import com.doz.app.com.doz.model.Person
import com.doz.app.com.doz.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.PagedResources
import org.springframework.hateoas.Resource
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@ConditionalOnProperty("repo.active")
@RestController
class PersonController(@Autowired private val personService: PersonService) {

    @RequestMapping("person", method = [RequestMethod.POST])
    fun addPerson(@RequestBody person: Person): Person {
        return personService.save(person = person)
    }

    @RequestMapping(value = ["persons"], method = [RequestMethod.GET])
    fun getPersonsPage(pageable: Pageable): Page<Person> {
        return personService.get(pageable = pageable)
    }

    @RequestMapping(value = ["persons/resource"], method = [RequestMethod.GET])
    fun getPersonsResource(pageable: Pageable, resourcesAssembler: PagedResourcesAssembler<Person>):
            PagedResources<Resource<Person>> {
        return resourcesAssembler.toResource(personService.get(pageable = pageable))
    }

    @RequestMapping(value = ["persons/jdbc"], method = [RequestMethod.GET])
    fun getPersonsJdbc(pageable: Pageable): Page<Person> {
        return personService.getPersons(pageable = pageable)
    }

    @RequestMapping(value = ["persons/jdbc/resource"], method = [RequestMethod.GET])
    fun getPersonsJdbcResource(pageable: Pageable, resourcesAssembler: PagedResourcesAssembler<Person>): PagedResources<Resource<Person>> {
        return resourcesAssembler.toResource(personService.getPersons(pageable = pageable))
    }

    @RequestMapping(value = ["persons/projection"], method = [RequestMethod.GET])
    fun getPersonsProjection(pageable: Pageable): Page<NameAndId> {
        return personService.getPersonsNameAndId(pageable = pageable)
    }
}
