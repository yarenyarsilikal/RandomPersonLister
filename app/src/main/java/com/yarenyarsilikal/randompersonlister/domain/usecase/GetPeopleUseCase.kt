package com.yarenyarsilikal.randompersonlister.domain.usecase

import com.yarenyarsilikal.randompersonlister.common.Resource
import com.yarenyarsilikal.randompersonlister.data.local.model.toPerson
import com.yarenyarsilikal.randompersonlister.domain.model.Person
import com.yarenyarsilikal.randompersonlister.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


/**
 * Created by yarenyarsilikal on 16.04.2022.
 */
class GetPeopleUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(
        next: String? = null,
        mFlowOne: (Flow<Resource<List<Person>>>) -> Unit,
        mFlowTwo: (Flow<Resource<List<Person>>>) -> Unit
    ) {
        val flowOne = flow<Resource<List<Person>>> {
            emit(Resource.Loading())

            repository.getPersons(next) { fetchResponse, fetchError ->
                val flowTwo = flow {
                    if (fetchError != null)
                        emit(Resource.Error(fetchError.errorDescription))

                    val list = fetchResponse?.people?.map { it.toPerson() }.orEmpty()
                    if (list.isEmpty()) {
                        emit(Resource.Nothing("Listelenmeye uygun kişi bulunamadı!"))
                    } else {
                        emit(Resource.Success(list))
                    }
                }
                mFlowTwo.invoke(flowTwo)
            }

        }
        mFlowOne.invoke(flowOne)
    }
}