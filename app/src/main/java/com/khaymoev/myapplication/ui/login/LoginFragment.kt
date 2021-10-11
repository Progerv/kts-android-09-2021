package com.khaymoev.myapplication.ui.login

import android.os.Bundle
import android.view.View
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
import com.khaymoev.myapplication.utils.hideKeyboard

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButtons()

        setUsernameTextChangedListener(binding.editTextEmailView, binding.editTextPasswordView)

        setPasswordTextChangedListener(binding.editTextEmailView, binding.editTextPasswordView)

        setPasswordEditorActionListener(binding.editTextPasswordView)

        loginViewModel.loginValidData.observe(viewLifecycleOwner,
            Observer { loginFormState ->
                if (loginFormState == null) {
                    return@Observer
                }
                binding.loginButton.isEnabled = loginFormState
            }
        )

    }

    private fun initButtons() {

        binding.loginButton.setOnClickListener {
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
}