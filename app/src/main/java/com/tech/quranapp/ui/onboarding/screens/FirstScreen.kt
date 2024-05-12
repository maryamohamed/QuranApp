package com.tech.quranapp.ui.onboarding.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tech.quranapp.R
import com.tech.quranapp.databinding.FragmentFirstScreenBinding
import com.tech.quranapp.util.declareViewPager

class FirstScreen : Fragment() {

    private lateinit var binding : FragmentFirstScreenBinding

    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        binding = FragmentFirstScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClicks()
    }

    private fun onClicks() {
        binding.nextArrow.setOnClickListener {
            declareViewPager(1)
        }
        binding.skipButton.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }
        onBoardingFinished()
    }

    private fun onBoardingFinished() {
        val sharedPref =
            requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}

