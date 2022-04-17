package com.yarenyarsilikal.randompersonlister.domain.model

data class People(
    val people: List<Person>,
    val next: String? = null
)