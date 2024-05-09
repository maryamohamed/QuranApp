package com.tech.quranapp.util

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.tech.quranapp.R

fun Fragment.declareViewPager(currentItem: Int) {
    val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
    viewPager?.currentItem = currentItem
}
fun Int.toAyaFormat() = "$this آيه "
fun Fragment.setLinearLayoutRecyclerView(recyclerView: RecyclerView?) {
    recyclerView?.layoutManager = LinearLayoutManager(
        activity,
        LinearLayoutManager.VERTICAL,
        false
    )
}
fun Fragment.showToast(message: Any?) {
    Toast.makeText(requireContext(),"$message", Toast.LENGTH_SHORT).show()
}
fun Fragment.replaceFragment(fragment: Fragment) {
    if (!(fragment.isAdded))
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment).addToBackStack(null)
            .commit()
}