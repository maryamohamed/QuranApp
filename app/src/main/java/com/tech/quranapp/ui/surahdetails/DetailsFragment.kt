package com.tech.quranapp.ui.surahdetails

//import com.tech.quranapp.ui.home.HomeFragmentDirections
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tech.care.base.BaseFragment
import com.tech.quranapp.databinding.FragmentDetailsBinding
import com.tech.quranapp.util.NetworkState
import com.tech.quranapp.util.setLinearLayoutRecyclerView
import com.tech.quranapp.util.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>()  {
    override val bindingInflater : (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate
    override val logTag : String = this::class.java.simpleName
    private val detailsViewModel : DetailsViewModel by viewModels()
    private var detailsAdapter : DetailsAdapter? = null
    private var surahId = 0


    override fun initialize() {
        setLinearLayoutRecyclerView(binding?.ayatRecyclerView)
//        surahId = DetailsFragmentArgs.fromBundle(requireArguments()).SurahDetailsResponse
        detailsViewModel.loadAyahsData(surahId)
        observers()
    }


    override fun addCallbacks() {
    }
    private fun observers() {
        detailsViewModel.ayahsData.observe(viewLifecycleOwner) {
            when (it.status) {
                NetworkState.Status.RUNNING -> {
                    com.tech.quranapp.util.ProgressLoading.show(requireActivity())
                }

                NetworkState.Status.SUCCESS -> {
                    val surahDetails = it.data as com.tech.quranapp.data.remote.model.SurahDetailsResponse
                    binding?.apply {
                        surahName.text = surahDetails.arabicName
                        surahType.text = surahDetails.type
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

