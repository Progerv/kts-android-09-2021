package com.khaymoev.myapplication.ui.main_page.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.khaymoev.myapplication.R
import com.khaymoev.myapplication.models.LoadingItem
import kotlinx.android.extensions.LayoutContainer

/**
 * Created by Igor Park on 24/03/2020.
 */
class PageLoadingAdapterDelegate :
    AbsListItemAdapterDelegate<LoadingItem, Any, PageLoadingAdapterDelegate.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_loading_page, parent, false)
        return Holder(itemView)
    }

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is LoadingItem
    }

    override fun onBindViewHolder(
        item: LoadingItem,
        holder: Holder,
        payloads: MutableList<Any>
    ) {
    }

    class Holder(
        override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer
}