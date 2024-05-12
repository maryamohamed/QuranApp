package com.tech.quranapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tech.care.base.SimpleBaseAdapter
import com.tech.quranapp.data.remote.model.SurahData
import com.tech.quranapp.databinding.SurahItemBinding
import com.tech.quranapp.util.toAyaFormat

class HomeAdapter(
    private var suraData : List<SurahData>,
    private val listener : HomeInteractionListener
) :
    SimpleBaseAdapter<SurahData, SurahItemBinding>(suraData) {
    override val bindingInflater : (LayoutInflater, ViewGroup?, Boolean) -> SurahItemBinding
        get() = SurahItemBinding::inflate

    override fun onBindViewHolder(
        holder : BaseViewHolder<SurahItemBinding>,
        position : Int,
        currentItem : SurahData
    ) {
        holder.binding.apply {
            surahNumber.text = currentItem.number.toString()
            arabicName.text = currentItem.name
            englishName.text = currentItem.englishName
            totalAyat.text = currentItem.numberOfAyahs?.toAyaFormat()
            root.setOnClickListener {
                listener.onClickSurah(currentItem)
            }
        }
    }
}

interface HomeInteractionListener : SimpleBaseAdapter.BaseInteractionListener {
    fun onClickSurah(surah : SurahData)
}
