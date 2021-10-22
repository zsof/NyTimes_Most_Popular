package hu.kzs.nytimes.ui.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.koin.getViewModelFromFactory
import com.bumptech.glide.Glide
import hu.kzs.nytimes.R
import hu.kzs.nytimes.databinding.FragmentDetailBinding
import hu.kzs.nytimes.model.Article
import org.koin.core.component.KoinComponent

class DetailsFragment(private var articleId: Long) : KoinComponent,
    RainbowCakeFragment<DetailsViewState, DetailsViewModel>() {
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_detail

    private var binding: FragmentDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
    }

    override fun onStart() {
        super.onStart()
        viewModel.load(articleId)
    }

    override fun render(viewState: DetailsViewState) {
        when (viewState) {
            is ArticleLoad -> {
                viewState.detailArticle?.let { setupArticleDetails(it) }
            }
            else -> return
        }
    }

    private fun setupArticleDetails(article: Article) = with(binding) {
        if (this == null) return@with

        titleDetailsText.text = article.title
        byDetailsText.text = article.byline
        dateDetailsText.text = article.publishedDate

        Glide.with(detailsImage)
            .load(article.imageUrl)
            .placeholder(R.drawable.default_image)
            .into(detailsImage)

        openDetailsButton.setOnClickListener {
            val defaultBrowse =
                Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
            defaultBrowse.data = Uri.parse(article.url)
            startActivity(defaultBrowse)
        }
    }
}