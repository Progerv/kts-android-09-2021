package com.khaymoev.myapplication.ui.main_page.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.khaymoev.myapplication.models.ArticleImageItem
import com.khaymoev.myapplication.models.ArticleItem
import com.khaymoev.myapplication.ui.main_page.delegates.ArticleImageItemDelegate
import com.khaymoev.myapplication.ui.main_page.delegates.ArticleItemDelegate

/**
 * @author Vasiliy Khaymoev on 27.09.2021.
 */
class ComplexDelegatesListAdapter(
    onSendLike: (item: Any) -> Unit,
    onOpenUnplashSite: (item: ArticleImageItem) -> Unit
) : AsyncListDifferDelegationAdapter<Any>(ComplexDiffCallback()) {

    init {
        delegatesManager
            .addDelegate(ArticleItemDelegate(onSendLike))
            .addDelegate(ArticleImageItemDelegate(onOpenUnplashSite))
            .addDelegate(PageLoadingAdapterDelegate())
    }

    class ComplexDiffCallback : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(first: Any, second: Any): Boolean {
            return first.javaClass == second.javaClass && when (first) {
                is ArticleItem -> first.uuid == (second as ArticleItem).uuid
                is ArticleImageItem -> first.uuid == (second as ArticleImageItem).uuid
                else -> true
            }
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(first: Any, second: Any): Boolean = first == second
    }

    /*
    private fun removeItem(item: Any) {
        val newItems = items.toMutableList().apply {
            remove(item)
        }
        items = newItems
    }
    */
}