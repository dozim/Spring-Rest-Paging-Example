package com.doz.app.com.doz.model

import org.springframework.data.rest.core.annotation.RepositoryRestResource
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator

@RepositoryRestResource(exported = false)
@Entity
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
data class Person(
        @Column(name = "name") val name: String,
        @Column(name = "forename") val forename: String,
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq") val id: Long = 0
)

