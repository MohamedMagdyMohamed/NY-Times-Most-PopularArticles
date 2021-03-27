package com.example.nytimesmostpopulararticles.utils

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.view.View

object UiUtils {

    fun getClickableSpanText(
        spannableString: SpannableString,
        startPos: Int,
        endPos: Int,
        onClick: () -> Unit
    ): SpannableString {
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                onClick.invoke()
            }
        }
        spannableString.setSpan(clickableSpan, startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        return spannableString
    }
}