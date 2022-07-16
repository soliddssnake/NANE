package com.techcareer.nane.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.techcareer.nane.data.repo.FoodDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FoodDetailFragmentViewModel @Inject constructor (var foodRepo: FoodDaoRepository) : ViewModel() {
    fun addFood(food_name: String, food_image_name: String, food_price: Int, food_order_quantity: Int, user_name: String){
        foodRepo.addToCart(food_name, food_image_name, food_price, food_order_quantity, user_name)
    }
}