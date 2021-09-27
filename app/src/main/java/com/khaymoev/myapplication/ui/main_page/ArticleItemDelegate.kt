package com.khaymoev.myapplication.ui.main_page

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.khaymoev.myapplication.R
import com.khaymoev.myapplication.models.ArticleItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_article.view.*

/**
 * @author Vasiliy Khaymoev on 27.09.2021.
 */
class ArticleItemDelegate(
    private val onItemClick: (item: ArticleItem) -> Unit
) : AbsListItemAdapterDelegate<Any, Any, ArticleItemDelegate.ViewHolder>() {

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is ArticleItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        return ViewHolder(itemView, onItemClick)
    }

    override fun onBindViewHolder(item: Any, viewHolder: ViewHolder, payloads: MutableList<Any>) {
        viewHolder.bind(item as ArticleItem)
    }

    inner class ViewHolder(
        override val containerView: View,
        private val onItemClick: (item: ArticleItem) -> Unit
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private var currentItem: ArticleItem? = null

        init {
            containerView.setOnClickListener { currentItem?.let(onItemClick) }
        }

        fun bind(item: ArticleItem) = with(containerView) {
            currentItem = item
            title.text = item.title
            amountLike.text = item.amountLike.toString()
            author.text = item.author
            email.text = item.email
        }
    }
}