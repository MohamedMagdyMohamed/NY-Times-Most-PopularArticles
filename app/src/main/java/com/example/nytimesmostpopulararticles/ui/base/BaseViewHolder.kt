package com.example.nytimesmostpopulararticles.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder(
    var viewBinding: ViewDataBinding
) : RecyclerView.ViewHolder(viewBinding.root)
