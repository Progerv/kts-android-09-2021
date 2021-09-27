package com.khaymoev.myapplication.ui.main_page

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.khaymoev.myapplication.R
import com.khaymoev.myapplication.databinding.FragmentMainBinding
import com.khaymoev.myapplication.models.ArticleImageItem
import com.khaymoev.myapplication.models.ArticleItem
import com.khaymoev.myapplication.models.LoadingItem
import com.khaymoev.myapplication.ui.main_page.adapter.ComplexDelegatesListAdapter
import com.khaymoev.myapplication.utils.PaginationScrollListener
import com.khaymoev.myapplication.utils.autoCleared
import java.util.*

class ComplexDelegatesListFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private var complexAdapter: ComplexDelegatesListAdapter by autoCleared()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        loadMoreItems()
    }

    private fun initList() {
        complexAdapter = ComplexDelegatesListAdapter(
            // Sharing
            onSendEmail = { complexItem ->
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:${complexItem.email}")
                    putExtra(Intent.EXTRA_SUBJECT, complexItem.title)
                }
                startActivity(intent)
            }
        )
        with(binding.list) {
            val orientation = RecyclerView.VERTICAL
            adapter = complexAdapter
            layoutManager = LinearLayoutManager(context, orientation, false)

            // Pagination
            addOnScrollListener(
                PaginationScrollListener(
                    layoutManager = layoutManager as LinearLayoutManager,
                    requestNextItems = ::loadMoreItems,
                    visibilityThreshold = 0
                )
            )

            addItemDecoration(DividerItemDecoration(context, orientation))
            setHasFixedSize(true)
        }
    }

    private fun getDefaultItems() = List(20) {
        val randomUUID = UUID.randomUUID()
        when ((1..2).random()) {
            1 -> ArticleItem(
                uuid = randomUUID,
                title = "Самый обыкновенный заголовок",
                amountLike = (1..1000).random(),
                author = "Автор: Хаймоев Василий",
                email = "Vasilii435@yandex.ru"
            )
            2 -> ArticleImageItem(
                title = "Самый обыкновенный заголовок картинки",
                uuid = randomUUID,
                author =  "Хаймоева Дарья"
            )
            else -> error("Wrong random number")
        }
    }

    private fun loadMoreItems() {
        val newItems = complexAdapter.items.toMutableList().apply {
            if (lastOrNull() is LoadingItem) {
                removeLastOrNull()
            }
        } + getDefaultItems() + LoadingItem()
        complexAdapter.items = newItems
        Log.d("Pagination", newItems.size.toString())
    }
}