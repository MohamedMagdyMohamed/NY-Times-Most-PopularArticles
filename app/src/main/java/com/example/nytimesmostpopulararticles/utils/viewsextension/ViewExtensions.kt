package com.example.nytimesmostpopulararticles.utils.viewsextension

import android.view.View

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}