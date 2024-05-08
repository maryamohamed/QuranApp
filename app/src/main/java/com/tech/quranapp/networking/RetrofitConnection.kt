package com.tech.quranapp.networking

import javax.inject.Inject

class RetrofitConnection  @Inject constructor(private val apiCalls: ApiCalls){

    suspend fun getSurah() = apiCalls.getSurah()

}
