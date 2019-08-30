package com.doz.app.com.doz.repository

import com.doz.app.com.doz.model.Company
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository : JpaRepository<Company, Long> {
    fun <T> findAllByNameStartingWith(nameStart: String, type: Class<T>): Collection<T>
}
