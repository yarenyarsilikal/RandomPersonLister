package com.yarenyarsilikal.randompersonlister.ui.main

import com.yarenyarsilikal.randompersonlister.domain.model.Person


/**
 * Created by yarenyarsilikal on 16.04.2022.
 */
data class PeopleListState(
    val isLoading: Boolean = false,
    val people: List<Person> = emptyList(),
    val error: String = "",
    val emptyListPlaceHolder : String = ""
)