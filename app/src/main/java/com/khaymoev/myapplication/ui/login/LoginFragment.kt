package com.khaymoev.myapplication.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.khaymoev.myapplication.R
import com.khaymoev.myapplication.databinding.FragmentLoginBinding
import com.khaymoev.myapplication.other.hideKeyboard
import timber.log.Timber

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val bindingView: FragmentLoginBinding by viewBinding()

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d("onViewCreated ${hashCode()}")

        initButton()

        setUsernameTextChangedListener(bindingView.editTextEmailView, bindingView.editTextPasswordView)

        setPasswordTextChangedListener(bindingView.editTextEmailView, bindingView.editTextPasswordView)

        setPasswordEditorActionListener(bindingView.editTextPasswordView)

        loginViewModel.loginValidData.observe(viewLifecycleOwner,
            Observer { loginFormState ->
                if (loginFormState == null) {
                    return@Observer
                }
                bindingView.loginButton.isEnabled = loginFormState
            }
        )

    }

    private fun initButton() {

        bindingView.loginButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMainFragment())
        }
    }

    private fun setUsernameTextChangedListener(emailEditText: EditText, passwordEditText: EditText) {
        emailEditText.doAfterTextChanged { text ->
            val username = text.toString().trim()

            val password = passwordEditText.text.toString().trim()
            loginViewModel.loginDataChanged(username, password)
        }
    }

    private fun setPasswordTextChangedListener(usernameEditText: EditText, passwordEditText: EditText) {
        passwordEditText.doAfterTextChanged { editable ->
            val username = usernameEditText.text.toString().trim()

            val password = editable.toString().trim()
            loginViewModel.loginDataChanged(username, password)
        }
    }

    private fun setPasswordEditorActionListener(passwordEditText: EditText) {
        passwordEditText.setOnEditorActionListener { _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                activity?.window?.hideKeyboard()
            }
            false
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
}