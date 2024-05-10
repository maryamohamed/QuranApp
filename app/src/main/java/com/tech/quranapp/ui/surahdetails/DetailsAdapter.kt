package com.tech.quranapp.ui.surahdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tech.care.base.SimpleBaseAdapter
import com.tech.quranapp.data.remote.model.Ayah
import com.tech.quranapp.data.remote.model.SurahDetailsResponse
import com.tech.quranapp.data.remote.model.VerseModel
import com.tech.quranapp.databinding.AyatItemBinding

class DetailsAdapter (private var surahDetails : List<VerseModel>) :
    SimpleBaseAdapter<VerseModel, AyatItemBinding>(surahDetails) {
    override val bindingInflater : (LayoutInflater, ViewGroup?, Boolean) -> AyatItemBinding
        get() = AyatItemBinding::inflate

    override fun onBindViewHolder(
        holder : BaseViewHolder<AyatItemBinding>,
        position : Int,
        currentItem : VerseModel
    ) {
        holder.binding.apply {
            ayahContent.text = currentItem.text
            ayahNumber.text = currentItem.verseNumber.toString()
        }
    }
}


