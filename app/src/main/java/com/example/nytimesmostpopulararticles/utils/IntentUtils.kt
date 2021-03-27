package com.example.nytimesmostpopulararticles.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

object IntentUtils {

    fun openArticlePage(context: Context, url: String) {
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url)
            )
        )
    }
}