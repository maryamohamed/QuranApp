package com.tech.quranapp.networking

import com.tech.quranapp.data.remote.model.AyatModel
import com.tech.quranapp.data.remote.model.SurahDetailsResponse
import com.tech.quranapp.data.remote.model.SurahModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCalls {

    @GET("surah")
    suspend fun  getSurah() : SurahModel
    @GET("surah/{surahNum}/ar.alafasy")
    suspend fun getSurahDetails(@Path("surahNum") surahNum: Int):SurahDetailsResponse
}