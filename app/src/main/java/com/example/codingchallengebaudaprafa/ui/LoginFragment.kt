package com.example.codingchallengebaudaprafa.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.codingchallengebaudaprafa.databinding.LoginViewBinding
import dagger.hilt.android.AndroidEntryPoint


/**
 * @author Rafael Bonilla
 * Login Fragment, main UI container.
 */
@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: LoginViewBinding? = null
    private val binding get() = _binding as LoginViewBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            LoginScreen(loginViewModel = viewModel)
        }
    }
}