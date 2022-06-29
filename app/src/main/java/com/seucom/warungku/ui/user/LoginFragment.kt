package com.seucom.warungku.ui.user

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.navigation.fragment.findNavController
import com.seucom.warungku.R
import com.seucom.warungku.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var binding : FragmentLoginBinding? = null
    private val bind get() = binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initAction()
    }

    private fun initUI() {
        bind.etEmail.apply {
            tvLabel.text = getString(R.string.email)
            edtText.hint = getString(R.string.input_email)
            edtText.imeOptions = EditorInfo.IME_ACTION_NEXT
            edtText.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        }

        bind.etPass.apply {
            tvLabel.text = getString(R.string.password)
            edtText.hint = getString(R.string.input_password)
            edtText.imeOptions = EditorInfo.IME_ACTION_DONE
        }

        bind.btnLogin.apply {
            text = getString(R.string.sign_in)
        }

    }

    private fun initAction() {
        bind.btnLogin.setOnClickListener {
            if (validation()) findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMainFragment())
        }
        bind.tvSignUp.setOnClickListener{
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }

    private fun validation() : Boolean {
        val email = ""
        val password = bind.etPass.edtText.text.toString()
        return if (password.length >= 6) true
        else {
            bind.etPass.edtText.error = "Min. 6 Karakter"
            false
        }
    }
}