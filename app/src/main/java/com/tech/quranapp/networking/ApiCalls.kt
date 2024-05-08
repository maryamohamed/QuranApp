package com.tech.quranapp.networking

import com.tech.quranapp.data.remote.model.SurahModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiCalls {

    @GET("surah")
    suspend fun  getSurah() : SurahModel
}