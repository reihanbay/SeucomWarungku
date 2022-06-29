package com.seucom.warungku.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.seucom.warungku.R
import com.seucom.warungku.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var binding : FragmentMainBinding? = null
    private val bind get() = binding!!

    private val link = "https://cdn.kibrispdr.org/data/572/gambar-toko-baju-yang-ada-di-jakarta-9.jpg"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAction()
        initUI(view)

    }
    private fun initUI(view: View) {
        bind.containerPrototype.apply {
            tvName.text = "Toko Baju Ej'N'Em"
            tvAddress.text = "Jalan Pegangsaan Timur no 56"
            tvKoordinat.text = "-6.1999555122960865, 106.84257825756093"
            Glide.with(view.context).load(link).into(ivShop)
        }
    }
    private fun initAction() {
        bind.btnAdd.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToEditShopFragment())
        }
        bind.containerPrototype.container.setOnClickListener {
            val name = bind.containerPrototype.tvName.text
            val coordinate = bind.containerPrototype.tvKoordinat.text
            val address = bind.containerPrototype.tvAddress.text
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailShopFragment(link, address.toString(), name.toString(), coordinate.toString()))
        }
    }

}