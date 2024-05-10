package com.tech.quranapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tech.care.base.BaseFragment
import com.tech.quranapp.R
import com.tech.quranapp.data.remote.model.Surah
import com.tech.quranapp.data.remote.model.SurahData
import com.tech.quranapp.data.remote.model.SurahModel
import com.tech.quranapp.databinding.FragmentHomeBinding
import com.tech.quranapp.ui.surahdetails.DetailsFragment
import com.tech.quranapp.util.ProgressLoading
import com.tech.quranapp.util.replaceFragment
import com.tech.quranapp.util.setLinearLayoutRecyclerView
import com.tech.quranapp.util.showToast
import com.tech.quranapp.utils.NetworkState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(), HomeInteractionListener {
    override val bindingInflater : (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate
    override val logTag : String = this::class.java.simpleName
    private val homeViewModel : HomeViewModel by viewModels()
    private var homeAdapter : HomeAdapter? = null
    override fun initialize() {
        setLinearLayoutRecyclerView(binding?.surahRecyclerView)
        homeViewModel.getSurah()
        observers()

    }

    override fun addCallbacks() {
    }

    private fun observers() {
        homeViewModel.homeViewModel.observe(viewLifecycleOwner) {
            when (it.status) {
                NetworkState.Status.RUNNING -> {
                    ProgressLoading.show(requireActivity())
                }

                NetworkState.Status.SUCCESS -> {
                    val surahModel = it.data as SurahModel
                    homeAdapter = HomeAdapter(surahModel.data as List<SurahData>, this)
                    if (surahModel.data.isEmpty()) {
                        binding?.surahRecyclerView?.visibility = View.GONE
                        binding?.placeHolder?.visibility = View.VISIBLE
                    }
                    binding?.surahRecyclerView?.adapter = homeAdapter

                    ProgressLoading.dismiss()
                }

                else -> {
                    it.massage?.let { it1 ->
                        showToast(it1.toString())
                    }
                    ProgressLoading.dismiss()
                }
            }
        }
    }


    override fun onClickSurah(surah: SurahData) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
        )

    }

}

