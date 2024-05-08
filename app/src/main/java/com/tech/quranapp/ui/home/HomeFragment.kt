package com.tech.quranapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tech.care.base.BaseFragment
import com.tech.quranapp.data.remote.model.Data
import com.tech.quranapp.data.remote.model.SurahModel
import com.tech.quranapp.databinding.FragmentHomeBinding
import com.tech.quranapp.util.ProgressLoading
import com.tech.quranapp.util.setLinearLayoutRecyclerView
import com.tech.quranapp.util.showToast
import com.tech.quranapp.utils.NetworkState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
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
                    homeAdapter = HomeAdapter(surahModel.data as List<Data>)
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

}