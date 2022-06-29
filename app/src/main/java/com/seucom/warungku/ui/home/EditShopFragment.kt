package com.seucom.warungku.ui.home

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.seucom.warungku.R
import com.seucom.warungku.databinding.FragmentEditShopBinding

class EditShopFragment : Fragment() {

    private var binding : FragmentEditShopBinding? = null
    private val bind get() = binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEditShopBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initAction()
    }

    private fun initAction() {
        bind.btnSubmit.setOnClickListener {
            val nama = bind.etName.edtText.text?.length
            val alamat = bind.etAddress.edtText.text?.length

            if (nama!! > 50 || alamat!! > 1000) {
                Toast.makeText(requireContext(), "Karakter Melebihi Batas Maksimal", Toast.LENGTH_LONG).show()
            } else {
                findNavController().navigate(EditShopFragmentDirections.actionEditShopFragmentToMainFragment())
            }
        }
    }

    private fun initUI() {
        bind.etName.apply {
            tvLabel.text = getString(R.string.name)
            edtText.hint = getString(R.string.input_name)
            edtText.imeOptions = EditorInfo.IME_ACTION_NEXT
            edtText.inputType = InputType.TYPE_CLASS_TEXT
            textField.counterMaxLength = 50
            textField.isCounterEnabled = true
        }

        bind.etCoordinate.apply {
            tvLabel.text = getString(R.string.coordinate)
            edtText.hint = getString(R.string.input_koordinat)
            edtText.imeOptions = EditorInfo.IME_ACTION_DONE
        }

        bind.etAddress.apply {
            tvLabel.text = getString(R.string.alamat)
            edtText.hint = getString(R.string.input_alamat)
            edtText.imeOptions = EditorInfo.IME_ACTION_DONE
            textField.counterMaxLength = 1000
            textField.isCounterEnabled = true
        }

        bind.btnSubmit.text = "Submit"

    }
}