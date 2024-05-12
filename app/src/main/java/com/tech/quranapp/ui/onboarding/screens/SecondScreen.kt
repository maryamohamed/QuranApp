package com.tech.quranapp.ui.onboarding.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tech.quranapp.databinding.FragmentSecondScreenBinding
import com.tech.quranapp.util.declareViewPager

class SecondScreen : Fragment() {

    private lateinit var binding : FragmentSecondScreenBinding

    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        binding = FragmentSecondScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // handle click events
        onClicks()
    }

    private fun onClicks() {
        binding.nextArrow.setOnClickListener {
            declareViewPager(2)
        }
        binding.backArrow.setOnClickListener {
            declareViewPager(1)
        }
        onBoardingFinished()
    }

    // handle on boarding when finish
    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }
}