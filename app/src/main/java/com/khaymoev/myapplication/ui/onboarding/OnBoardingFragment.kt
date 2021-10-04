package com.khaymoev.myapplication.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.khaymoev.myapplication.R
import com.khaymoev.myapplication.databinding.FragmentOnBoardingBinding
import com.khaymoev.myapplication.view_page_adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_on_boarding.*

class OnBoardingFragment: Fragment(R.layout.fragment_on_boarding) {

    private val binding: FragmentOnBoardingBinding by viewBinding(FragmentOnBoardingBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager2.adapter = ViewPagerAdapter()

        val indicator = binding.indicator
        indicator.attachToPager(viewPager2)

    }
}