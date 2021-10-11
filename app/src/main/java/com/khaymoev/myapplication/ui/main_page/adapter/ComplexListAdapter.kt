package com.khaymoev.myapplication.ui.main_page.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khaymoev.myapplication.R
import com.khaymoev.myapplication.models.ArticleImageItem
import com.khaymoev.myapplication.models.ArticleItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_article.view.*
import kotlinx.android.synthetic.main.item_article_image.view.*

class ComplexListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = emptyList<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        fun getLayoutId(viewType: Int): Int {
            return when (viewType) {
                ARTICLE_ITEM_VIEW_ID -> R.layout.item_article
                ARTICLE_IMAGE_ITEM_VIEW_ID -> R.layout.item_article_image
                else -> throw error("Unknown view type")
            }
        }

        val itemView = LayoutInflater.from(parent.context)
            .inflate(getLayoutId(viewType), parent, false)
        val removeCallback = { item: Any, position: Int ->
            removeItem(item, position)
        }

        return when (viewType) {
            ARTICLE_ITEM_VIEW_ID -> ArticleViewHolder(itemView, removeCallback)
            ARTICLE_IMAGE_ITEM_VIEW_ID -> ArticleImageViewHolder(itemView, removeCallback)
            else -> throw error("Unknown view type")
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ArticleItem -> ARTICLE_ITEM_VIEW_ID
            is ArticleImageItem -> ARTICLE_IMAGE_ITEM_VIEW_ID
            else -> error("Unknown item")
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ArticleViewHolder -> holder.bind(items[position] as ArticleItem)
            is ArticleImageViewHolder -> holder.bind(items[position] as ArticleImageItem)
            else -> error("Unknown view holder")
        }
    }

    fun setItems(newItems: List<Any>) {
        items = newItems.toList()
        notifyDataSetChanged()
    }

    private fun removeItem(item: Any, position: Int) {
        val newItems = items.toMutableList().apply {
            remove(item)
        }
        items = newItems
        notifyItemRemoved(position)
    }

    class ArticleViewHolder(
        override val containerView: View,
        onItemClick: (item: ArticleItem, position: Int) -> Unit
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private var currentItem: ArticleItem? = null

        init {
            containerView.setOnClickListener {
                currentItem?.let { item ->
                    onItemClick.invoke(item, adapterPosition)
                }
            }
        }

        fun bind(item: ArticleItem) = with(containerView) {
            currentItem = item
            title.text = item.title
            amountLike.text = item.amountLike.toString()
            author.text = item.author
        }
    }

    class ArticleImageViewHolder(
        override val containerView: View,
        onItemClick: (item: ArticleImageItem, position: Int) -> Unit
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private var currentItem: ArticleImageItem? = null

        init {
            containerView.setOnClickListener {
                currentItem?.let { item ->
                    onItemClick.invoke(item, adapterPosition)
                }
            }
        }

        fun bind(item: ArticleImageItem) = with(containerView) {
            currentItem = item
            title_image.text = item.title
            author_image.text = item.author
        }
    }

    companion object {
        private const val ARTICLE_ITEM_VIEW_ID = 1
        private const val ARTICLE_IMAGE_ITEM_VIEW_ID = 2
    }
}