package com.example.nytimesmostpopulararticles.ui.articleslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimesmostpopulararticles.R
import com.example.nytimesmostpopulararticles.databinding.FragmentArticlesListBinding
import com.example.nytimesmostpopulararticles.ui.base.BaseFragment
import com.example.nytimesmostpopulararticles.utils.VerticalSpaceItemDecoration
import com.example.nytimesmostpopulararticles.utils.recyclerview.OnItemClickListener
import com.example.nytimesmostpopulararticles.utils.viewsextension.autoCleared
import com.example.nytimesmostpopulararticles.utils.viewsextension.getDimen
import com.example.nytimesmostpopulararticles.utils.viewsextension.hide
import com.example.nytimesmostpopulararticles.utils.viewsextension.show
import com.example.nytimesmostpopulararticles.vo.Result
import com.example.nytimesmostpopulararticles.vo.ViewedArticle
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticlesListFragment : BaseFragment() {

    private var binding by autoCleared<FragmentArticlesListBinding>()
    private var articlesAdapter by autoCleared<ArticlesListAdapter>()

    private val viewModel by viewModel<ArticlesListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding = FragmentArticlesListBinding.inflate(inflater, container, false)

        binding = dataBinding
        initUi()
        return binding.root
    }

    private fun initUi() {
        setupAdapter()
        setupRecycleView()
    }

    private fun setupAdapter() {
        articlesAdapter = ArticlesListAdapter(object : OnItemClickListener<ViewedArticle> {
            override fun onItemClick(item: ViewedArticle) {

            }
        })
    }

    private fun setupRecycleView() {
        binding.rvArticles.adapter = articlesAdapter
        binding.rvArticles.layoutManager = LinearLayoutManager(requireContext())
        binding.rvArticles.addItemDecoration(VerticalSpaceItemDecoration(getDimen(R.dimen.vertical_spacing_16dp).toInt()))
    }

    override fun observeViewModel() {
        viewModel.articlesListResultLiveData.observe(viewLifecycleOwner, { result ->
            handleFetchArticlesList(result)
        })
    }

    private fun handleFetchArticlesList(result: Result<List<ViewedArticle>>?) {
        when (result) {
            is Result.Success -> {
                handleLoading(show = false)
                result.data?.let { data ->
                    articlesAdapter.updateList(data)
                }
            }
            is Result.Error -> {
                handleLoading(show = false)
                handleErrorResponse(result.error)
            }
            is Result.Loading -> {
                handleLoading(result.show)
            }
        }
    }

    override fun showProgress() {
        binding.pbArticles.show()
    }

    override fun hideProgress() {
        binding.pbArticles.hide()
    }

}