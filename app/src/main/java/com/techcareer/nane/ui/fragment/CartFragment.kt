package com.techcareer.nane.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.techcareer.nane.R
import com.techcareer.nane.databinding.FragmentCartBinding
import com.techcareer.nane.ui.adapter.FoodInCartAdapter
import com.techcareer.nane.ui.viewmodel.CartFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        binding.cartFragment = this

        binding.cartFragmentToolbarTitle = "Sepetim"

        viewModel.foodInCartList.observe(viewLifecycleOwner){
            val adapter = FoodInCartAdapter(requireContext(),it, viewModel)
            binding.cartAdapter = adapter
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CartFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

}