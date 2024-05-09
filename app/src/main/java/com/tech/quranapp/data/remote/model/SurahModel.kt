package com.tech.quranapp.data.remote.model


import com.google.gson.annotations.SerializedName

data class SurahModel(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("data")
    val `data`: List<SurahData?>? = null,
    @SerializedName("status")
    val status: String? = null
)