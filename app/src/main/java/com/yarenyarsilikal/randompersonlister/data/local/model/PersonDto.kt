package com.yarenyarsilikal.randompersonlister.data.local.model

import com.yarenyarsilikal.randompersonlister.domain.model.Person


/**
 * Created by yarenyarsilikal on 16.04.2022.
 */
data class PersonDto(val id: Int, val fullName: String)

fun PersonDto.toPerson(): Person = Person(id = id, fullName = fullName)
