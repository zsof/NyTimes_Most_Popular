package hu.kzs.nytimes.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.koin.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import hu.kzs.nytimes.R
import hu.kzs.nytimes.databinding.FragmentListBinding
import hu.kzs.nytimes.ui.details.DetailsFragment
import org.koin.core.component.KoinComponent

class MainFragment : KoinComponent, RainbowCakeFragment<MainViewState, MainViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_list

    private lateinit var adapter: ArticleAdapter
    private var binding: FragmentListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }

    override fun render(viewState: MainViewState) = with(binding) {
        if (this == null) return@with

        when (viewState) {
            is ArticlesReady -> {
                adapter.submitList(viewState.articlesData)
                swipeRefreshLayout.isRefreshing = viewState.isRefresh
            }
            else -> return
        }
    }

    private fun onItemSelected(articleId: Long) {
        navigator?.add(DetailsFragment(articleId))
    }

    private fun setupRecyclerView() = with(binding) {
        if (this == null) return@with
        adapter = ArticleAdapter()
        mainRecyclerView.adapter = adapter
        adapter.setOnArticleClickedListener { articleId ->
            onItemSelected(articleId)
        }

        swipeRefreshLayout.setColorSchemeColors(
            ContextCompat.getColor(
                requireContext(),
                R.color.colorPrimary
            )
        )
        swipeRefreshLayout.setOnRefreshListener {
            viewModel.refreshArticle()
        }
    }
}