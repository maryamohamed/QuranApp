package com.tech.quranapp.util

import android.app.Activity
import android.app.Dialog
import com.tech.quranapp.R


object ProgressLoading {

    private var progress: Dialog? = null
    private var hasActivity: Boolean = false

    private fun init(activity: Activity) {
        progress = Dialog(activity)
        progress?.setContentView(R.layout.progress)
    }

    // handle show and dismiss
    fun show(activity: Activity) {
        if (!hasActivity) {
            hasActivity = true
            init(activity)
        }

        if (!(activity).isFinishing) {
            try {
                progress?.show()
            } catch (e: Exception) {
                e.localizedMessage
            }
        }
    }

    fun dismiss() {
        progress?.dismiss()
        hasActivity = false
    }
}