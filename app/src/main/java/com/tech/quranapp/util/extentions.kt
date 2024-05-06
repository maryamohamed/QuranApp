package com.tech.quranapp.util

import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.tech.quranapp.R

fun Fragment.declareViewPager(currentItem: Int) {
    val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
    viewPager?.currentItem = currentItem
}