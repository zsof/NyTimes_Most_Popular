package com.example.blankkoin.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.example.blankkoin.model.Article


object ArticleComparator : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem:Article, newItem: Article): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}
