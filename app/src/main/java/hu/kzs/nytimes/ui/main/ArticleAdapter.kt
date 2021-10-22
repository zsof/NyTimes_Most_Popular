package hu.kzs.nytimes.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hu.kzs.nytimes.R
import hu.kzs.nytimes.databinding.ItemArticlesMainBinding
import hu.kzs.nytimes.model.Article
import org.koin.dsl.module

val ArticleAdapterModule = module {
    factory { ArticleAdapter() }
}

class ArticleAdapter : ListAdapter<Article, ArticleAdapter.ArticlesViewHolder>(
    ArticleComparator
) {

    private lateinit var onArticleClickedListener: (articleId: Long) -> Unit
    private var binding: ItemArticlesMainBinding? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        return ArticlesViewHolder(

            ItemArticlesMainBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        )
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ArticlesViewHolder(binding: ItemArticlesMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val titleMainText: TextView = binding.titleText
        private val byMainText: TextView = binding.byText
        private val dateMainText: TextView = binding.dateText
        private val mainImage: ImageView = binding.mainImage
        var articleItem: Article? = null

        fun bind(article: Article) = with(binding) {
            articleItem = article
            titleMainText.text = article.title
            dateMainText.text = article.publishedDate
            byMainText.text = article.byline

            Glide.with(itemView)
                .load(article.imageUrl)
                .placeholder(R.drawable.default_image)
                .into(mainImage)
        }

        init {
            itemView.setOnClickListener {
                onArticleClickedListener.invoke(articleItem!!.id)
            }
        }
    }

    fun setOnArticleClickedListener(listener: (articleId: Long) -> Unit) {
        onArticleClickedListener = listener
    }
}