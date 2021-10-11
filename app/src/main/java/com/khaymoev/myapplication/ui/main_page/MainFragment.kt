package com.khaymoev.myapplication.ui.main_page

import android.os.Bundle
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
import com.khaymoev.myapplication.ui.main_page.adapter.ComplexListAdapter
import com.khaymoev.myapplication.utils.autoCleared
import java.util.*

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private var complexAdapter: ComplexListAdapter by autoCleared()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initList()
        setDefaultItems()
    }

    private fun initList() {
        complexAdapter = ComplexListAdapter()
        with(binding.list) {
            val orientation = RecyclerView.VERTICAL
            adapter = complexAdapter
            layoutManager = LinearLayoutManager(context, orientation, false)
            addItemDecoration(DividerItemDecoration(context, orientation))
            setHasFixedSize(true)
        }
    }

    private fun setDefaultItems() {
        val defaultItems = List(20) {
            val randomUUID = UUID.randomUUID()
            when ((1..2).random()) {
                1 -> ArticleItem(
                    uuid = randomUUID,
                    title = "Самый обыкновенный заголовок",
                    amountLike = (1..1000).random(),
                    author = "Автор: Хаймоев Василий"
                )
                2 -> ArticleImageItem(
                    title = "Самый обыкновенный заголовок картинки",
                    uuid = randomUUID,
                    author =  "Хаймоева Дарья"
                )
                else -> error("Wrong random number")
            }
        }
        complexAdapter.setItems(defaultItems)
    }
}