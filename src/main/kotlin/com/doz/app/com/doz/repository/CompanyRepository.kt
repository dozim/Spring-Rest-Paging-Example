package com.doz.app.com.doz.repository

import com.doz.app.com.doz.model.Company
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(exported = true)
interface CompanyRepository : PagingAndSortingRepository<Company, Long> {

    fun <T> findAllByNameStartingWith(nameStart: String, type: Class<T>): Collection<T>
}
