package com.doz.app.com.doz.model

import org.springframework.data.rest.core.annotation.RepositoryRestResource
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator

@RepositoryRestResource(exported = true)
@Entity
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
data class Company(
        @Column(name = "name") val name: String,
        @Column(name = "employees") @OneToMany(fetch = FetchType.LAZY) val employees: List<Person>,
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq") val id: Long = 0
)
