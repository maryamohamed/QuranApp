package com.tech.quranapp.data.remote.model


import com.google.gson.annotations.SerializedName

data class SurahDetailsResponse(
    @SerializedName("englishName") var name: String?,
    @SerializedName("name") var arabicName: String?,
    @SerializedName("numberOfAyahs") var verseNum: Int?,
    @SerializedName("revelationType") var type: String?,
    @SerializedName("ayahs") var verses: List<VerseModel?>?
)
data class VerseModel(
    var audio: String?,
    var text: String?,
    @SerializedName("numberInSurah") var verseNumber: Int?
)