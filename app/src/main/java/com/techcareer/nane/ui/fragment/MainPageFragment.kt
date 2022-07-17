package com.techcareer.nane.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.techcareer.nane.R
import com.techcareer.nane.databinding.FragmentMainPageBinding
import com.techcareer.nane.ui.adapter.FoodAdapter
import com.techcareer.nane.ui.viewmodel.MainPageFragmentViewModel
import com.techcareer.nane.util.moveIn
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel: MainPageFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_page, container, false)

        binding.mainPageFragment = this
        binding.mainPageToolBarTitle = "NANE"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarMainPage)

        viewModel.foodList.observe(viewLifecycleOwner) {
            val adapter = FoodAdapter(requireContext(), it)
            binding.foodAdapter = adapter
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: MainPageFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_cart -> {
                Navigation.moveIn(requireView(),R.id.mainToCart)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}