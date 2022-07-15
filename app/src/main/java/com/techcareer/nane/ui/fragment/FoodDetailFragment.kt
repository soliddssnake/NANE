package com.techcareer.nane.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.text.isDigitsOnly
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.techcareer.nane.R
import com.techcareer.nane.databinding.FragmentFoodDetailBinding
import com.techcareer.nane.retrofit.ApiUtils.Companion.BASE_URL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodDetailFragment : Fragment() {
    private lateinit var binding: FragmentFoodDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_food_detail, container, false)
        binding.foodDetailFragment = this

        binding.foodDetailToolbarTitle = "Yemek Detayı"

        val bundle: FoodDetailFragmentArgs by navArgs()
        val receivedFood = bundle.food
        binding.foodObject = receivedFood

        Picasso.get().load(BASE_URL + "yemekler/resimler/" + receivedFood.food_image_name).into(binding.imageViewDetail)

        val numbers = ArrayList<Int>()
        numbers.addAll(1..50)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, android.R.id.text1, numbers)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.totalAmount = "Toplam Tutar: ${numbers[p2] * receivedFood.food_price} TL"
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        return binding.root
    }

    fun buttonAddToCartClicked() {
        Log.e("aaaa",binding.totalAmount!!.filter { it.isDigit() })
    }

}