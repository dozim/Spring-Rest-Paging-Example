package com.doz.app.com.doz.service

import com.doz.app.com.doz.model.Company
import com.doz.app.com.doz.model.NameAndId
import com.doz.app.com.doz.model.NameOnly
import com.doz.app.com.doz.repository.CompanyRepository
import org.springframework.stereotype.Service

@Service
class CompanyService(private val companyRepository: CompanyRepository) {

    fun getCompaniesByNameAsNameAndId(nameStartsWith: String) =
            companyRepository.findAllByNameStartingWith(nameStartsWith, NameAndId::class.java)

    fun getCompaniesByNameAsNameOnly(nameStartsWith: String) =
            companyRepository.findAllByNameStartingWith(nameStartsWith, NameOnly::class.java)

    fun saveCompany(company: Company) = companyRepository.save(company)
}
