package com.khaymoev.myapplication.ui.main_page

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.khaymoev.myapplication.R
import com.khaymoev.myapplication.models.ArticleImageItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_article_image.view.*

/**
 * @author Vasiliy Khaymoev on 27.09.2021.
 */
class ArticleImageItemDelegate(
    private val onItemClick: (item: ArticleImageItem) -> Unit
) : AbsListItemAdapterDelegate<Any, Any, ArticleImageItemDelegate.ViewHolder>() {

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is ArticleImageItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article_image, parent, false)
        return ViewHolder(itemView, onItemClick)
    }

    override fun onBindViewHolder(item: Any, viewHolder: ViewHolder, payloads: MutableList<Any>) {
        viewHolder.bind(item as ArticleImageItem)
    }

    inner class ViewHolder(
        override val containerView: View,
        private val onItemClick: (item: ArticleImageItem) -> Unit
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private var currentItem: ArticleImageItem? = null

        init {
            containerView.setOnClickListener { currentItem?.let(onItemClick) }
        }

        fun bind(item: ArticleImageItem) = with(containerView) {
            currentItem = item
            title_image.text = item.title
            author_image.text = item.author
        }
    }
}