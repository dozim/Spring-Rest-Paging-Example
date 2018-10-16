package com.doz.app.com.doz.model.root

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator

@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
abstract class Id (
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq") override val id: Long = 0
) : UniqueId