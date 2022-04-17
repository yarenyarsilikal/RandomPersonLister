package com.yarenyarsilikal.randompersonlister.data.local.model


/**
 * Created by yarenyarsilikal on 16.04.2022.
 */

typealias FetchCompletionHandler = (FetchResponse?, FetchError?) -> Unit

data class ProcessResult(
    val fetchResponse: FetchResponse?,
    val fetchError: FetchError?,
    val waitTime: Double
)

data class FetchResponse(val people: List<PersonDto>, val next: String?)

data class FetchError(val errorDescription: String)




