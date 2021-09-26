package com.example.blankkoin.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.example.blankkoin.model.ArticlesData


object ArticleComparator : DiffUtil.ItemCallback<MainPresenter.ArticlesPresenterData>() {
    override fun areItemsTheSame(oldItem: MainPresenter.ArticlesPresenterData, newItem: MainPresenter.ArticlesPresenterData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MainPresenter.ArticlesPresenterData, newItem: MainPresenter.ArticlesPresenterData): Boolean {
        return oldItem == newItem
    }
}
