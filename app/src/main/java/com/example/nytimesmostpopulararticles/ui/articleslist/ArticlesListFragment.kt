package com.example.nytimesmostpopulararticles.ui.articleslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nytimesmostpopulararticles.databinding.FragmentArticlesListBinding
import com.example.nytimesmostpopulararticles.ui.base.BaseFragment

class ArticlesListFragment : BaseFragment() {

    private lateinit var binding: FragmentArticlesListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding = FragmentArticlesListBinding.inflate(inflater, container, false)

        binding = dataBinding
        return binding.root
    }

}