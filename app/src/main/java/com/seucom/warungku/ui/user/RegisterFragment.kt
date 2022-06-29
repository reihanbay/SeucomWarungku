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
import com.seucom.warungku.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var binding : FragmentRegisterBinding? = null
    private val bind get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return bind.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initAction()
    }

    private fun initUI() {
        bind.etEmail.apply {
            textField.hint = getString(R.string.email)
            textField.placeholderText = getString(R.string.input_email)
            edtText.imeOptions = EditorInfo.IME_ACTION_NEXT
            edtText.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        }

        bind.etPass.apply {
            textField.hint = getString(R.string.password)
            textField.placeholderText = getString(R.string.input_password)
            edtText.imeOptions = EditorInfo.IME_ACTION_DONE
        }

        bind.etRePass.apply {
            textField.hint = getString(R.string.password)
            textField.placeholderText = getString(R.string.input_password)
            edtText.imeOptions = EditorInfo.IME_ACTION_DONE
        }

        bind.btnRegister.apply {
            text = getString(R.string.sign_up)
        }

    }

    private fun initAction() {
        bind.btnRegister.setOnClickListener {
            if (validation()) findNavController().popBackStack()
        }
        bind.tvSignIn.setOnClickListener{
            findNavController().popBackStack()
        }
    }

    private fun validation() : Boolean {
        val email = ""
        val password = bind.etPass.edtText.text.toString()
        val repassword= bind.etRePass.edtText.text.toString()
        val vPass = if (password.length >= 6 ) true
        else {
            bind.etPass.edtText.error = "Min. 6 Karakter"
            false
        }

        val vRepass = when {
            repassword.length >= 6 -> true
            repassword.length < 6 -> {
                bind.etRePass.edtText.error = "Min. 6 Karakter"
                false
            }
            repassword == password -> true
            repassword != password -> {
                bind.etRePass.edtText.error = "Password tidak sesuai"
                false
            }
            else -> false
        }

        return vPass && vRepass
    }

}