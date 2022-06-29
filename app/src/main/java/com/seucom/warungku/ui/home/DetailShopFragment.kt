package com.seucom.warungku.ui.home

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.seucom.warungku.R
import com.seucom.warungku.databinding.FragmentDetailShopBinding

class DetailShopFragment : Fragment() {


    private var binding : FragmentDetailShopBinding? = null
    private val bind get() = binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailShopBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI(view)
        initAction()
    }

    private fun initAction() {
        bind.btnEdit.setOnClickListener {
            findNavController().navigate(DetailShopFragmentDirections.actionDetailShopFragmentToEditShopFragment())
        }
    }

    private fun initUI(view: View) {
        val data = DetailShopFragmentArgs.fromBundle(arguments as Bundle)
        bind.etName.apply {
            tvLabel.text = getString(R.string.name)
            edtText.setText(data.name)
            edtText.isEnabled = false
        }

        bind.etCoordinate.apply {
            tvLabel.text = getString(R.string.coordinate)
            edtText.setText(data.coordinate)
            edtText.isEnabled = false
        }

        bind.etAddress.apply {
            tvLabel.text = getString(R.string.alamat)
            edtText.isEnabled = false
            edtText.setText(data.alamat)
        }

        Glide.with(view).load(data.image).into(bind.ivShop)

    }
}