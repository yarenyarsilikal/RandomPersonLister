package com.yarenyarsilikal.randompersonlister.domain.repository

import com.yarenyarsilikal.randompersonlister.data.local.model.Result


/**
 * Created by yarenyarsilikal on 16.04.2022.
 */
interface Repository {
    suspend fun getPeople(next: String? = null): Result?
}