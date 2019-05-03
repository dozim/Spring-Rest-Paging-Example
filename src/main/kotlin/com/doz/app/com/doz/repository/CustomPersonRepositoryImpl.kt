package com.doz.app.com.doz.repository

import com.doz.app.com.doz.model.Person
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Repository
@Transactional
class CustomPersonRepositoryImpl(private val entityManager: EntityManager) : CustomPersonRepository {

    @Modifying
    override fun getPersonTestData(): List<Person> {
        val personOne = Person("Quak", "Alfred")
        val personSecond = Person("Hebe", "Frederic")

        entityManager.persist(personOne)
        entityManager.persist(personSecond)

        return listOf(personOne, personSecond)
    }
}
