package com.tech.quranapp.data.remote.model

data class DetailsModel(
    val code: Int,
    val `data`: NewData,
    val status: String
)

data class NewData(
    val ayahs: List<AyahDetails>,
    val edition: EditionDetails,
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
    val number: Int,
    val numberOfAyahs: Int,
    val revelationType: String
)

data class AyahDetails(
    val hizbQuarter: Int,
    val juz: Int,
    val manzil: Int,
    val number: Int,
    val numberInSurah: Int,
    val page: Int,
    val ruku: Int,
    val sajda: Boolean,
    val text: String
)

data class EditionDetails(
    val direction: String,
    val englishName: String,
    val format: String,
    val identifier: String,
    val language: String,
    val name: String,
    val type: String
)