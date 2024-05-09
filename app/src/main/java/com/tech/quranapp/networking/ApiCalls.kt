package com.tech.quranapp.networking

import com.tech.quranapp.data.remote.model.AyatModel
import com.tech.quranapp.data.remote.model.SurahModel
import retrofit2.http.GET

interface ApiCalls {

    @GET("surah")
    suspend fun  getSurah() : SurahModel
    @GET("quran/quran-uthmani")
    suspend fun getAyat(): AyatModel
}