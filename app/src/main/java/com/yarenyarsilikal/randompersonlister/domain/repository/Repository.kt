package com.yarenyarsilikal.randompersonlister.domain.repository

import com.yarenyarsilikal.randompersonlister.data.local.model.FetchCompletionHandler


/**
 * Created by yarenyarsilikal on 16.04.2022.
 */
interface Repository {
    suspend fun getPersons(next: String? = null, completionHandler: FetchCompletionHandler)
}