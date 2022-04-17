package com.yarenyarsilikal.randompersonlister.data.repository

import com.yarenyarsilikal.randompersonlister.data.local.datasource.LocalDataSource
import com.yarenyarsilikal.randompersonlister.data.local.model.Result
import com.yarenyarsilikal.randompersonlister.domain.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import javax.inject.Inject


/**
 * Created by yarenyarsilikal on 16.04.2022.
 */

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : Repository {

    override suspend fun getPeople(next: String?): Result? {
        val value = CoroutineScope(Dispatchers.IO).async {
            var personResult: Result? = null
            localDataSource.fetch(next) { fetchResult, fetchError ->
                personResult = Result(fetchResult, fetchError)
            }
            delay(2000)
            return@async personResult
        }
        return value.await()
    }

}