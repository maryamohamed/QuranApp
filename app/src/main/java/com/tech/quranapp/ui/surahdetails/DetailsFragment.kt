package com.tech.quranapp.ui.surahdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tech.care.base.BaseFragment
import com.tech.quranapp.R
import com.tech.quranapp.data.remote.model.Surah
import com.tech.quranapp.data.remote.model.SurahData
import com.tech.quranapp.data.remote.model.SurahModel
import com.tech.quranapp.databinding.FragmentDetailsBinding
import com.tech.quranapp.databinding.FragmentHomeBinding
import com.tech.quranapp.ui.home.HomeAdapter
import com.tech.quranapp.ui.home.HomeViewModel
import com.tech.quranapp.util.ProgressLoading
import com.tech.quranapp.util.setLinearLayoutRecyclerView
import com.tech.quranapp.util.showToast
import com.tech.quranapp.utils.NetworkState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>()  {
    override val bindingInflater : (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate
    override val logTag : String = this::class.java.simpleName
    private val detailsViewModel : DetailsViewModel by viewModels()
    private var detailsAdapter : DetailsAdapter? = null
    private lateinit var surah : Surah


    override fun initialize() {
        setLinearLayoutRecyclerView(binding?.ayatRecyclerView)
        detailsViewModel.loadAyatData(surah)
        observers()
    }

    override fun addCallbacks() {
    }
    private fun observers() {
        detailsViewModel.ayatData.observe(viewLifecycleOwner) {
            when (it.status) {
                com.tech.quranapp.utils.NetworkState.Status.RUNNING -> {
                    com.tech.quranapp.util.ProgressLoading.show(requireActivity())
                }

                com.tech.quranapp.utils.NetworkState.Status.SUCCESS -> {
                    val surahData = it.data as com.tech.quranapp.data.remote.model.SurahData
                    binding?.apply {
                        surahName.text = surahData.name
                        surahType.text = surahData.revelationType
                        ayatRecyclerView.adapter = detailsAdapter
                    }
                }

                else -> {
                    it.massage?.let { it1 ->
                        showToast(it1.toString())
                    }
                    com.tech.quranapp.util.ProgressLoading.dismiss()
                }
            }
        }
    }
    companion object {
        private const val SURAH = "surah"
        fun newInstance(surah: String) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putString(SURAH, surah)
            }
        }
    }
}

