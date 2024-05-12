package com.tech.quranapp.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tech.quranapp.databinding.FragmentViewPagerBinding
import com.tech.quranapp.ui.onboarding.screens.FirstScreen
import com.tech.quranapp.ui.onboarding.screens.SecondScreen
import com.tech.quranapp.ui.onboarding.screens.ThirdScreen

class ViewPagerFragment : Fragment() {

    private lateinit var binding : FragmentViewPagerBinding

    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // create array list of fragment
        val fragmentList = arrayListOf(FirstScreen(), SecondScreen(), ThirdScreen())

        // create view pager adapter
        val adapter =
            ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)

        // set adapter
        binding.viewPager.adapter = adapter
    }
}