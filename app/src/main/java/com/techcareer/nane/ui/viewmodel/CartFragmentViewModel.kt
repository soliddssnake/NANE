package com.techcareer.nane.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.techcareer.nane.data.entity.FoodInCart
import com.techcareer.nane.data.repo.FoodDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartFragmentViewModel @Inject constructor(var frepo: FoodDaoRepository) : ViewModel() {
    var foodInCartList = MutableLiveData<List<FoodInCart>>()
    var foodInCartObject = FoodInCart(0,"","",0,0)

    init {
        uploadFoodInCart()
        foodInCartList = frepo.takeFoodInCart()
    }

    fun uploadFoodInCart(){
        frepo.getAllFoodInCart(foodInCartObject.user_name)
    }

    fun delete(cart_food_id:Int, user_name: String) {
        frepo.deleteFoodInCart(cart_food_id, user_name)
    }
}