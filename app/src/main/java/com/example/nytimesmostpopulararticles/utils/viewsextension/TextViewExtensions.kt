package com.example.nytimesmostpopulararticles.utils.viewsextension

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.nytimesmostpopulararticles.utils.DateUtils
import java.util.*

@BindingAdapter("date", "format", requireAll = false)
fun TextView.formatDate(
    date: Date,
    format: String?
) {
    text = DateUtils.formatDate(date, format ?: DateUtils.DEFAULT_DATE_FORMAT)
}