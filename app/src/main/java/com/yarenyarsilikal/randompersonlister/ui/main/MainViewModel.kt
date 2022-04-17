package com.yarenyarsilikal.randompersonlister.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.yarenyarsilikal.randompersonlister.domain.model.Person
import com.yarenyarsilikal.randompersonlister.domain.usecase.GetPeopleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by yarenyarsilikal on 16.04.2022.
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeopleUseCase,
) : ViewModel() {

    fun getPeople(): Flow<PagingData<Person>> = Pager(
        config = PagingConfig(enablePlaceholders = true, pageSize = 20),
        pagingSourceFactory = {
            PeoplePagingSource(
                getPeopleUseCase
            )
        }
    ).flow.cachedIn(viewModelScope)


/*    fun getPeople(next: String? = null) {
       getPeopleUseCase(next).onEach { result ->
           when (result) {
            is Resource.Success -> {
                flow = Pager(
                    config = PagingConfig(enablePlaceholders = false, pageSize = 50),
                    pagingSourceFactory = {
                        PeoplePagingSource(
                            getPeopleUseCase
                        )
                    }
                ).flow

            }
            is Resource.Error -> {
                _state.value = PeopleListState(
                    error = result.message ?: "An unexpected error occurred!"
                )
            }
            is Resource.Loading -> {
                _state.value = PeopleListState(
                    isLoading = true
                )
            }
            is Resource.Nothing -> {

            }
        }
       }

    }*/
}


//    private val eventFlow = { it: Flow<Resource<People>> ->
//        it.onEach { result ->
//            handleState(result)
//        }.launchIn(viewModelScope)
//    }
//
//    init {
//        getPeople()
//    }
//
//    private fun getPeople(next: String? = null) {
//        handleState(Resource.Loading())
//        getPeopleUseCase(next, eventFlow, eventFlow)
//    }
//
//    private fun handleState(result: Resource<People>) {
//        when (result) {
//            is Resource.Success -> {
//                _state.value = PeopleListState(
//                    people = result.data?.people ?: emptyList(),
//                    next = result.data?.next
//                )
//            }
//            is Resource.Error -> {
//                _state.value = PeopleListState(
//                    error = result.message ?: "An unexpected error occurred!"
//                )
//            }
//            is Resource.Loading -> {
//                _state.value = PeopleListState(
//                    isLoading = true
//                )
//            }
//            is Resource.Nothing -> {
//                _state.value = PeopleListState(
//                    emptyListPlaceHolder = result.message ?: ""
//                )
//            }
//        }
//    }

