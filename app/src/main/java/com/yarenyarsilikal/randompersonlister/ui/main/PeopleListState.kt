package com.yarenyarsilikal.randompersonlister.ui.main

import com.yarenyarsilikal.randompersonlister.domain.model.People
import com.yarenyarsilikal.randompersonlister.domain.model.Person


/**
 * Created by yarenyarsilikal on 16.04.2022.
 */
data class PeopleListState(
    val isLoading: Boolean = false,
    val success : People? = null,
    val error: String = "",
)
