package com.doz.app.com.doz.repository

import com.doz.app.com.doz.model.Address
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(exported = true)
interface AddressRepository : PagingAndSortingRepository<Address, Long>