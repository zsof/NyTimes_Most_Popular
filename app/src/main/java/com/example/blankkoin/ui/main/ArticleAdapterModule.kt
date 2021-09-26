package com.example.blankkoin.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.blankkoin.databinding.ItemArticlesMainBinding

import org.koin.dsl.module


val ArticleAdapterModule = module {
    factory { ArticleAdapter() }
}

class ArticleAdapter : ListAdapter<MainPresenter.ArticlesPresenterData, ArticleAdapter.ArticlesViewHolder>(ArticleComparator) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {

        return ArticlesViewHolder(ItemArticlesMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val articles = getItem(position)
        holder.articleItem = articles

        holder.tvTitle.text = articles.title
       holder.tvDate.text = articles.published_date
        holder.tvBy.text = articles.byline

        Glide.with(holder.imageMain)
            .load(articles.url)
            .into(holder.imageMain)
    }

    inner class ArticlesViewHolder(binding: ItemArticlesMainBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvTitle: TextView = binding.titleMainText
        val tvBy: TextView = binding.byMainText
        val tvDate: TextView = binding.dateMainText
        val imageMain: ImageView = binding.mainImage

        var articleItem: MainPresenter.ArticlesPresenterData? = null

       /* init {
            binding.root.setOnClickListener {
                articleItem?.let { //TODO navigate
                }
            }
        } */
    }


}