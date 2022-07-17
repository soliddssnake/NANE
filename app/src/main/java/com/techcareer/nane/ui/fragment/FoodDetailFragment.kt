package com.techcareer.nane.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import com.techcareer.nane.R
import com.techcareer.nane.data.entity.FoodInCart
import com.techcareer.nane.databinding.FragmentFoodDetailBinding
import com.techcareer.nane.retrofit.ApiUtils.Companion.BASE_URL
import com.techcareer.nane.ui.viewmodel.FoodDetailFragmentViewModel
import com.techcareer.nane.util.moveIn
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodDetailFragment : Fragment() {
    private lateinit var binding: FragmentFoodDetailBinding
    private lateinit var viewModel: FoodDetailFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_food_detail, container, false)
        binding.foodDetailFragment = this

        binding.foodDetailToolbarTitle = "Yemek Detayı"

        val bundle: FoodDetailFragmentArgs by navArgs()
        val receivedFood = bundle.food
        binding.foodObject = receivedFood
        binding.foodInCartObject = FoodInCart(0, "", "", 0, 0)

        Picasso.get().load(BASE_URL + "yemekler/resimler/" + receivedFood.food_image_name).into(binding.imageViewDetail)

        val numbers = ArrayList<Int>()
        numbers.addAll(1..50)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, android.R.id.text1, numbers)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.orderQuantity = numbers[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: FoodDetailFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonAddToCartClicked(
        food_name: String,
        food_image_name: String,
        food_price: Int,
        food_order_quantity: Int,
        user_name: String,
        v: View
    ) {
        viewModel.addFood(food_name, food_image_name, food_price, food_order_quantity, user_name)
        Snackbar.make(binding.buttonAddToCart, "Sepetinize Eklendi", Snackbar.LENGTH_LONG).setAction("SEPETİM") {
            Navigation.moveIn(v, R.id.detailToCart)
        }.show()

    }

}