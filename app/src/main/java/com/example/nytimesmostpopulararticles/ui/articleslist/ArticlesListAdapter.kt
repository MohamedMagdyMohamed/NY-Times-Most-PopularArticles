package com.example.nytimesmostpopulararticles.ui.articleslist

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.nytimesmostpopulararticles.databinding.CellArticleBinding
import com.example.nytimesmostpopulararticles.ui.base.BaseRecyclerViewAdapter
import com.example.nytimesmostpopulararticles.ui.base.BaseViewHolder
import com.example.nytimesmostpopulararticles.utils.recyclerview.OnItemClickListener
import com.example.nytimesmostpopulararticles.vo.ViewedArticle

class ArticlesListAdapter(
    onItemClickListener: OnItemClickListener<ViewedArticle>
) : BaseRecyclerViewAdapter<ViewedArticle, BaseViewHolder>(ArrayList(), onItemClickListener) {

    override fun bindCurrentItem(
        holder: BaseViewHolder,
        currentItem: ViewedArticle,
        position: Int
    ) {
    }

    override fun getItemViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder {
        val binding = CellArticleBinding.inflate(inflater, parent, false)
        return BaseViewHolder(binding)
    }
}