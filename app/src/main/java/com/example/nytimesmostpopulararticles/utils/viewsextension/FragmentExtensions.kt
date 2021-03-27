package com.example.nytimesmostpopulararticles.utils.viewsextension

import androidx.fragment.app.Fragment
import com.example.nytimesmostpopulararticles.utils.AutoClearedValue


/**
 * Creates an [AutoClearedValue] associated with this fragment.
 */
fun <T : Any> Fragment.autoCleared() = AutoClearedValue<T>(this)


fun Fragment.getDimen(resId: Int): Float {
    return requireContext().resources.getDimension(resId)
}