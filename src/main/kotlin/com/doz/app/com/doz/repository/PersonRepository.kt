package com.doz.app.com.doz.repository

import com.doz.app.com.doz.model.NameAndId
import com.doz.app.com.doz.model.Person
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional


interface PersonRepository : PagingAndSortingRepository<Person, Long> {

    @Transactional
    @Query(
            value = "SELECT * FROM Person",
            countQuery = "SELECT COUNT(p.id) FROM Person p",
            nativeQuery = true
    )
    fun findAllNative(pageable: Pageable): Page<Person>

    @Transactional
    @Query("SELECT p.name AS name, p.id AS id FROM Person p")
    fun findAllAsNameAndId(pageable: Pageable): Page<NameAndId>

    @Transactional
    @Query("SELECT p FROM Person p WHERE p.name = :name")
    fun findAllByName(@Param("name") name: String)

    fun findPersonByNameIsNotNull(pageable: Pageable): Slice<Person>

    fun findByForenameAndName(forename: String, name: String, pageable: Pageable): Page<Person>
}
