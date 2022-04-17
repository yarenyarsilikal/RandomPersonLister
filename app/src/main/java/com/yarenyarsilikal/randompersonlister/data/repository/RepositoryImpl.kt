package com.yarenyarsilikal.randompersonlister.data.repository

import com.yarenyarsilikal.randompersonlister.data.local.datasource.LocalDataSource
import com.yarenyarsilikal.randompersonlister.data.local.model.FetchCompletionHandler
import com.yarenyarsilikal.randompersonlister.domain.repository.Repository
import javax.inject.Inject


/**
 * Created by yarenyarsilikal on 16.04.2022.
 */

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : Repository {

    override suspend fun getPersons(next: String?, completionHandler: FetchCompletionHandler) {
        localDataSource.fetch(next, completionHandler)
    }
}