package com.doz.app.com.doz.repository

import com.doz.app.com.doz.model.NameAndId
import com.doz.app.com.doz.model.Person
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(exported = false, path = "persons",collectionResourceRel = "persons")
interface PersonRepository : PagingAndSortingRepository<Person, Long> {

    fun save(person: Person): Person

    @Query(
            value = "SELECT * FROM Person",
            countQuery = "SELECT COUNT(p.ID) FROM Person p",
            nativeQuery = true
    )
    fun findAllPersons(pageable: Pageable): Page<Person>

    @Query(
            value = "SELECT p.name AS name, p.id AS id FROM Person p"
    )
    fun findByName(name: Pageable): Page<NameAndId>


}
