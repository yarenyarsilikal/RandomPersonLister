package com.yarenyarsilikal.randompersonlister.domain.usecase

import com.yarenyarsilikal.randompersonlister.domain.repository.Repository
import javax.inject.Inject


/**
 * Created by yarenyarsilikal on 16.04.2022.
 */
class GetPeopleUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(
        next: String? = null,
    ) = repository.getPeople(next)
}