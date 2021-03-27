package com.example.nytimesmostpopulararticles.ui.articledetail

import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.nytimesmostpopulararticles.BR
import com.example.nytimesmostpopulararticles.R
import com.example.nytimesmostpopulararticles.databinding.FragmentArticleDetailBinding
import com.example.nytimesmostpopulararticles.ui.base.BaseFragment
import com.example.nytimesmostpopulararticles.utils.IntentUtils
import com.example.nytimesmostpopulararticles.utils.UiUtils
import com.example.nytimesmostpopulararticles.utils.viewsextension.autoCleared
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticleDetailFragment : BaseFragment() {

    private var binding by autoCleared<FragmentArticleDetailBinding>()

    private val viewModel by viewModel<ArticleDetailViewModel>()
    private val params by navArgs<ArticleDetailFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.viewArticle = params.viewedArticles
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding = FragmentArticleDetailBinding.inflate(inflater, container, false)

        binding = dataBinding
        initUi()
        return binding.root
    }

    private fun initUi() {
        binding.setVariable(BR.viewedArticle, viewModel.viewArticle)
        binding.executePendingBindings()
        setupViewArticleText()
    }

    private fun setupViewArticleText() {
        val text = getString(R.string.fragment_article_detail_tv_view_article_web)
        val spannableString = SpannableString(text)
        val clickableSpannableString = UiUtils.getClickableSpanText(
            spannableString,
            CLICK_HERE_START_POS,
            text.length,
            onClick = { onViewWebArticleClicked() }
        )
        binding.tvViewArticleWeb.text = clickableSpannableString
        binding.tvViewArticleWeb.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun onViewWebArticleClicked() {
        IntentUtils.openArticlePage(requireContext(), viewModel.viewArticle.url)
    }

    companion object {
        private const val CLICK_HERE_START_POS = 21
    }
}
