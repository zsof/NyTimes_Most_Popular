package hu.kzs.nytimes.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hu.kzs.nytimes.model.ArticleModel
import hu.kzs.nytimes.R
import hu.kzs.nytimes.databinding.ItemArticlesMainBinding
import org.koin.dsl.module

val ArticleAdapterModule = module {
    factory { ArticleAdapter() }
}

class ArticleAdapter : ListAdapter<ArticleModel, ArticleAdapter.ArticlesViewHolder>(
    ArticleComparator
) {

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
            .load(articles.imageUrl)
            .placeholder(R.drawable.default_image)
            .into(holder.mainImage)
    }

    inner class ArticlesViewHolder(binding: ItemArticlesMainBinding) : RecyclerView.ViewHolder(binding.root) {
        val titleMainText: TextView = binding.titleMainText
        val byMainText: TextView = binding.byMainText
        val dateMainText: TextView = binding.dateMainText
        val mainImage: ImageView = binding.mainImage
        var articleItem: ArticleModel? = null

        init {
            itemView.setOnClickListener {
                articleItem?.let { item -> listener?.onItemSelected(item.id)
                println(item.id)}
                println(articleItem?.id)
            }
        }
    }

    interface Listener {
        fun onItemSelected(articleId: Long)
    }
}