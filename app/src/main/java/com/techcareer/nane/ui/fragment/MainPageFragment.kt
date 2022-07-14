package com.techcareer.nane.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.techcareer.nane.R
import com.techcareer.nane.databinding.FragmentMainPageBinding
import com.techcareer.nane.ui.adapter.FoodAdapter
import com.techcareer.nane.ui.viewmodel.MainPageFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel: MainPageFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_page, container, false)

        binding.mainPageFragment = this
        binding.mainPageToolBarTitle = "NANE"

        viewModel.foodList.observe(viewLifecycleOwner) {
            val adapter = FoodAdapter(requireContext(), it)
            binding.foodAdapter = adapter
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainPageFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

}