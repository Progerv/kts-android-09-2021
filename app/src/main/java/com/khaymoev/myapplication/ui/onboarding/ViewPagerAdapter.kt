package com.khaymoev.myapplication.view_page_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.khaymoev.myapplication.R
import com.khaymoev.myapplication.ui.onboarding.OnBoardingFragmentDirections
import kotlinx.android.synthetic.main.item_page.view.*

class ViewPagerAdapter : RecyclerView.Adapter<PagerVH>() {

    private val colors = intArrayOf(
        android.R.color.holo_green_light,
        android.R.color.holo_blue_light,
        android.R.color.holo_orange_light
    )

    private val descriptionsPage = listOf<String>(
        "Просмотр фотографий",
        "Установка лайков",
        "Добавление в избранное"
        )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))

    override fun getItemCount(): Int = colors.size

    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {
        textDescription.text = descriptionsPage[position]
        container.setBackgroundResource(colors[position])
        container.skip_text.setOnClickListener {
            findNavController().navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToLoginFragment())
        }
    }

}

class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)