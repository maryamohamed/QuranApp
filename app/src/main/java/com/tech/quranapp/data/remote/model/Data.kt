package com.tech.quranapp.data.remote.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("edition")
    val edition: Edition? = null,
    @SerializedName("surahs")
    val surahs: List<Surah?>? = null
)