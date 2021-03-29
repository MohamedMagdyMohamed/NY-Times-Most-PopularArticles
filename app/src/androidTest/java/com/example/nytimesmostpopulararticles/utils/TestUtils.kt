package com.example.nytimesmostpopulararticles.utils

import com.example.nytimesmostpopulararticles.helpers.RecyclerViewMatcher

object TestUtils {

    fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher? {
        return RecyclerViewMatcher(recyclerViewId)
    }
}