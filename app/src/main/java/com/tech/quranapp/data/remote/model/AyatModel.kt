package com.tech.quranapp.data.remote.model


import com.google.gson.annotations.SerializedName

data class AyatModel(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("data")
    val `data`: Data? = null,
    @SerializedName("status")
    val status: String? = null
)