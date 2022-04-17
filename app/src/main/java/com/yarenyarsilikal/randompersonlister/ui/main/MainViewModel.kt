package com.yarenyarsilikal.randompersonlister.ui.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yarenyarsilikal.randompersonlister.common.Resource
import com.yarenyarsilikal.randompersonlister.domain.model.Person
import com.yarenyarsilikal.randompersonlister.domain.usecase.GetPeopleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by yarenyarsilikal on 16.04.2022.
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeopleUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(PeopleListState())
    val state: State<PeopleListState> = _state

    private val eventFlow = { it: Flow<Resource<List<Person>>> ->
        it.onEach { result ->
            handleState(result)
        }.launchIn(viewModelScope)
    }

    init {
        getPeople()
    }

    private fun getPeople(next: String? = null) {
        handleState(Resource.Loading())
        getPeopleUseCase(next, eventFlow, eventFlow)
    }

    private fun handleState(result: Resource<List<Person>>) {
        when (result) {
            is Resource.Success -> {
                _state.value = PeopleListState(
                    people = result.data ?: emptyList()
                )
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
                _state.value = PeopleListState(
                    emptyListPlaceHolder = result.message ?: ""
                )
            }
        }
    }

}