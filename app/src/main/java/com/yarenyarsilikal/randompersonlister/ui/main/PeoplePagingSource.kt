package com.yarenyarsilikal.randompersonlister.ui.main

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yarenyarsilikal.randompersonlister.data.local.model.toPerson
import com.yarenyarsilikal.randompersonlister.domain.model.Person
import com.yarenyarsilikal.randompersonlister.domain.usecase.GetPeopleUseCase


/**
 * Created by yarenyarsilikal on 17.04.2022.
 */
class PeoplePagingSource(
    private val useCase: GetPeopleUseCase
) : PagingSource<Int, Person>() {

    override fun getRefreshKey(state: PagingState<Int, Person>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Person> {
        val key = params.key?.toString()

        val result = useCase(key)
        if (result?.fetchResponse != null) {
            return LoadResult.Page(
                result.fetchResponse.people.map { it.toPerson() },
                null,
                result.fetchResponse.next?.toInt(),
            )
        }
        return LoadResult.Error(
            Exception(result?.fetchError?.errorDescription)
        )
    }
}
