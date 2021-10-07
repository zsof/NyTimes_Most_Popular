package com.example.blankkoin.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.blankkoin.R
import com.example.blankkoin.databinding.ItemArticlesMainBinding
import com.example.blankkoin.model.Article
//import com.example.blankkoin.model.MediaMetaData

import org.koin.dsl.module


val ArticleAdapterModule = module {
    factory { ArticleAdapter() }
}

class ArticleAdapter : ListAdapter<Article, ArticleAdapter.ArticlesViewHolder>(ArticleComparator) {

    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        return ArticlesViewHolder(ItemArticlesMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val articles = getItem(position)
        holder.articleItem = articles
        holder.titleMainText.text = articles.title
        holder.dateMainText.text = articles.publishedDate
        holder.byMainText.text = articles.byline

        Glide.with(holder.mainImage)
            .load(articles.url)
            .placeholder(R.drawable.default_image)
            .into(holder.mainImage)
    }

    inner class ArticlesViewHolder(binding: ItemArticlesMainBinding) : RecyclerView.ViewHolder(binding.root) {
        val titleMainText: TextView = binding.titleMainText
        val byMainText: TextView = binding.byMainText
        val dateMainText: TextView = binding.dateMainText
        val mainImage: ImageView = binding.mainImage
        var articleItem: Article? = null

        init {
            itemView.setOnClickListener {
                articleItem?.let { item -> listener?.onItemSelected(item.id) }
            }
        }
    }

    interface Listener {
        fun onItemSelected(articleId: Long)
    }
}