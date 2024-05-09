package com.tech.quranapp.data.remote.model


import com.google.gson.annotations.SerializedName

data class Ayah(
    @SerializedName("hizbQuarter")
    val hizbQuarter: Int? = null,
    @SerializedName("juz")
    val juz: Int? = null,
    @SerializedName("manzil")
    val manzil: Int? = null,
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("numberInSurah")
    val numberInSurah: Int? = null,
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("ruku")
    val ruku: Int? = null,
    @SerializedName("sajda")
    val sajda: Boolean? = null,
    @SerializedName("text")
    val text: String? = null
)