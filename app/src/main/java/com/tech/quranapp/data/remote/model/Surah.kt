package com.tech.quranapp.data.remote.model


import com.google.gson.annotations.SerializedName

data class Surah(
    @SerializedName("ayahs")
    val ayahs: List<Ayah?>? = null,
    @SerializedName("englishName")
    val englishName: String? = null,
    @SerializedName("englishNameTranslation")
    val englishNameTranslation: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("revelationType")
    val revelationType: String? = null
)