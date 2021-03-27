package com.example.nytimesmostpopulararticles.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesmostpopulararticles.BR
import com.example.nytimesmostpopulararticles.utils.recyclerview.OnItemClickListener

abstract class BaseRecyclerViewAdapter<T, VH : BaseViewHolder>(
    protected val itemsList: ArrayList<T> = ArrayList()
) : RecyclerView.Adapter<VH>() {

    protected var clickListener: OnItemClickListener<T>? = null

    constructor(itemsList: ArrayList<T>, clickListener: OnItemClickListener<T>) : this(itemsList) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        return getItemViewHolder(inflater, parent, viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val currentItem = itemsList[position]
        bindCurrentItem(holder, currentItem, position)
        clickListener?.let {
            holder.viewBinding.setVariable(BR.onItemClickListener, clickListener)
        }
        holder.viewBinding.setVariable(BR.item, currentItem)
        holder.viewBinding.executePendingBindings()
    }

    abstract fun bindCurrentItem(holder: VH, currentItem: T, position: Int)

    abstract fun getItemViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): VH

    override fun getItemCount(): Int {
        return itemsList.size
    }

    fun getItem(position: Int): T {
        return itemsList[position]
    }

    open fun updateList(newList: List<T>) {
        itemsList.clear()
        itemsList.addAll(newList)
        notifyDataSetChanged()
    }
}