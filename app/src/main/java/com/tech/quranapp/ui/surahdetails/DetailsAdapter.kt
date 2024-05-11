package com.tech.quranapp.ui.surahdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tech.care.base.SimpleBaseAdapter
import com.tech.quranapp.data.remote.model.Ayah
import com.tech.quranapp.data.remote.model.AyahDetails
import com.tech.quranapp.data.remote.model.SurahDetailsResponse
import com.tech.quranapp.data.remote.model.VerseModel
import com.tech.quranapp.databinding.AyatItemBinding
import com.tech.quranapp.databinding.SurahItemBinding

class DetailsAdapter (private var ayahList: ArrayList<AyahDetails>) :RecyclerView.Adapter<DetailsAdapter.AyahViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyahViewHolder {
        val binding = AyatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AyahViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ayahList.size
    }

    override fun onBindViewHolder(holder: AyahViewHolder, position: Int) {
        holder.bind(ayahList[position])
    }
    inner class AyahViewHolder(val binding:AyatItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(ayahDetails: AyahDetails) {
            binding.apply {
                ayahContent.text =ayahDetails.text
                ayahNumber.text=ayahDetails.number.toString()

            }

        }
    }

}


