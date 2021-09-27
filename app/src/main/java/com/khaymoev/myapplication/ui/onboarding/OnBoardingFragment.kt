package com.khaymoev.myapplication.ui.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.khaymoev.myapplication.R
import com.khaymoev.myapplication.databinding.FragmentOnboardingBinding
import timber.log.Timber

class OnBoardingFragment : Fragment(R.layout.fragment_onboarding) {

    private val bindingView: FragmentOnboardingBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButton()

        Timber.d("onViewCreated ${hashCode()}")

    }

    private fun initButton() {
        bindingView.clickMy.setOnClickListener {
            findNavController().navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToLoginFragment())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("onAttach ${hashCode()}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate ${hashCode()}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView ${hashCode()}")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("onActivityCreated ${hashCode()}")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart ${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume ${hashCode()}")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPause ${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop ${hashCode()}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("onDestroyView ${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy ${hashCode()}")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("onDetach ${hashCode()}")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Timber.d("onViewStateRestored ${hashCode()}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.d("onSaveInstanceState ${hashCode()}")
    }
}