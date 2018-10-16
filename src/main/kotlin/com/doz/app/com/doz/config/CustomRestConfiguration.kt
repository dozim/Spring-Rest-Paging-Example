package com.doz.app.com.doz.config

import com.doz.app.com.doz.model.Person
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.repository.support.Repositories
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy.RepositoryDetectionStrategies
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter



@Configuration
class CustomRestConfiguration {

    @Bean
    fun repositoryRestConfigurer(): RepositoryRestConfigurer {

        return object : RepositoryRestConfigurerAdapter() {

            override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration) {
                config.repositoryDetectionStrategy = RepositoryDetectionStrategies.ANNOTATED
                config.exposeIdsFor(Person::class.java)
            }
        }
    }

    @Bean
    fun repositories(applicationContext:ApplicationContext): Repositories {
        return Repositories(applicationContext)
    }
}