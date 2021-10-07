package com.example.blankkoin.ui.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.koin.getViewModelFromFactory
import com.bumptech.glide.Glide
import com.example.blankkoin.R
import com.example.blankkoin.databinding.FragmentDetailBinding


import org.koin.core.component.KoinComponent

class DetailsFragment(private var articleId:Long) : KoinComponent, RainbowCakeFragment<DetailsViewState, DetailsViewModel>() {
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_detail

    private var binding: FragmentDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentDetailBinding.bind(view)
    }

    override fun onStart() {
        super.onStart()
        viewModel.load(articleId)
    }

    override fun render(viewState: DetailsViewState) {
        articleDetail(viewState)
    }

    private fun articleDetail(detailsViewState: DetailsViewState) {
        val articleDetails = detailsViewState.detailArticle ?: return

        binding?.titleDetailsText?.text=articleDetails.title
        binding?.byDetailsText?.text=articleDetails.byline
        binding?.dateDetailsText?.text=articleDetails.publishedDate

        binding?.let {
            Glide.with(it.detailsImage)
                .load(articleDetails.imageUrl)
                .placeholder(R.drawable.default_image)
                .into(it.detailsImage)
        }

        binding?.openDetailsButton?.setOnClickListener {
            val defaultBrowse= Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
            defaultBrowse.data= Uri.parse(articleDetails.url)
            startActivity(defaultBrowse)
        }
    }
}

