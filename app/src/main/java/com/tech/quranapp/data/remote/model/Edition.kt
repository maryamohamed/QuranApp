package com.tech.quranapp.data.remote.model


import com.google.gson.annotations.SerializedName

data class Edition(
    @SerializedName("englishName")
    val englishName: String? = null,
    @SerializedName("format")
    val format: String? = null,
    @SerializedName("identifier")
    val identifier: String? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null
)