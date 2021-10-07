package com.example.blankkoin.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.example.blankkoin.model.ArticleModel

object ArticleComparator : DiffUtil.ItemCallback<ArticleModel>() {
    override fun areItemsTheSame(oldItem:ArticleModel, newItem: ArticleModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
        return oldItem == newItem
    }
}
