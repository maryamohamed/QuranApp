package com.tech.quranapp.networking

import com.tech.quranapp.data.remote.model.DetailsModel
import com.tech.quranapp.data.remote.model.SurahModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCalls {

    @GET("surah")
    suspend fun getSurah() : SurahModel

    @GET("surah/{offset}")
    suspend fun getSurahDetails(@Path("offset") surahNumber : Int) : DetailsModel
}