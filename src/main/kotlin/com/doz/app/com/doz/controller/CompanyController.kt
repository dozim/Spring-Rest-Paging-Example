package com.doz.app.com.doz.controller

import com.doz.app.com.doz.model.Company
import com.doz.app.com.doz.service.CompanyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/companies"])
class CompanyController(private val companyService: CompanyService) {

    @GetMapping
    fun getCompaniesByName(
            @RequestParam("nameOnly") nameOnly: Boolean,
            @RequestParam("name") name: String): Collection<Any> {

        if (nameOnly) {
            return companyService.getCompaniesByNameAsNameOnly(name)
        } else {
            return companyService.getCompaniesByNameAsNameAndId(name)
        }
    }

    @PostMapping
    fun saveCompany(@RequestBody company: Company): Company {
        return companyService.saveCompany(company)
    }
}
