package hu.kzs.nytimes.ui.main

import androidx.recyclerview.widget.DiffUtil
import hu.kzs.nytimes.model.ArticleModel

object ArticleComparator : DiffUtil.ItemCallback<ArticleModel>() {
    override fun areItemsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
        return oldItem == newItem
    }
}
