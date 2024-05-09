package com.tech.quranapp.ui.surahdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tech.care.base.SimpleBaseAdapter
import com.tech.quranapp.data.remote.model.Ayah
import com.tech.quranapp.databinding.AyatItemBinding

class DetailsAdapter (private var ayatData : List<Ayah>) :
    SimpleBaseAdapter<Ayah, AyatItemBinding>(ayatData) {
    override val bindingInflater : (LayoutInflater, ViewGroup?, Boolean) -> AyatItemBinding
        get() = AyatItemBinding::inflate

    override fun onBindViewHolder(
        holder : BaseViewHolder<AyatItemBinding>,
        position : Int,
        currentItem : Ayah
    ) {
        holder.binding.apply {
            ayahContent.text = currentItem.text
            ayahNumber.text = currentItem.numberInSurah.toString()
        }
    }
}


