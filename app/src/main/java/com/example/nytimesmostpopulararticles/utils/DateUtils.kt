package com.example.nytimesmostpopulararticles.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtils {
    const val DEFAULT_DATE_FORMAT = "yyyy-MM-dd"

    fun formatDate(date: Date, format: String = DEFAULT_DATE_FORMAT): String {
        val dateFormat = SimpleDateFormat(format, Locale.ENGLISH)
        return dateFormat.format(date)
    }
}
