package com.doz.app.com.doz.controller

import com.doz.app.com.doz.model.NameAndId
import com.doz.app.com.doz.model.Person
import com.doz.app.com.doz.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.PagedResources
import org.springframework.hateoas.Resource
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/persons"])
class PersonController(@Autowired private val personService: PersonService) {

    @PostMapping
    fun addPerson(@RequestBody person: Person): Person {
        return personService.save(person = person)
    }

    @GetMapping
    fun getPersons(pageable: Pageable): Page<Person> {
        return personService.getAll(pageable = pageable)
    }

    @GetMapping("/resource")
    fun getPersonsResource(pageable: Pageable, resourcesAssembler: PagedResourcesAssembler<Person>): PagedResources<Resource<Person>> {
        return resourcesAssembler.toResource(personService.getAll(pageable = pageable))
    }

    @GetMapping("/jdbc")
    fun getPersonsJdbc(pageable: Pageable): Page<Person> {
        return personService.getPersons(pageable = pageable)
    }

    @GetMapping("/jdbc/resource")
    fun getPersonsJdbcResource(pageable: Pageable, resourcesAssembler: PagedResourcesAssembler<Person>): PagedResources<Resource<Person>> {
        return resourcesAssembler.toResource(personService.getPersons(pageable = pageable))
    }

    @GetMapping("/projection")
    fun getPersonsProjection(pageable: Pageable): Page<NameAndId> {
        return personService.getPersonsNameAndId(pageable = pageable)
    }

    @GetMapping("/slice")
    fun getPersonsAsSlice(pageable: Pageable): Slice<Person> {
        return personService.findPersonByNameIsNotNull(pageable = pageable)
    }

    @GetMapping("/async")
    fun getPersonsAsync(forename: String): ListenableFuture<Person> {
        return personService.getOneByForename(forename)
    }

    @GetMapping("/testdata")
    fun getPersonsTestData(): List<Person> {
        return personService.getPersonTestData()
    }

    @GetMapping(params = ["forename", "name"])
    fun getPersonsByForenameAndName(
            @RequestParam("forename") forename: String,
            @RequestParam("name") name: String,
            pageable: Pageable):Page<Person> {
        return personService.getPersonsByForenameAndName(forename, name, pageable)
    }
}
