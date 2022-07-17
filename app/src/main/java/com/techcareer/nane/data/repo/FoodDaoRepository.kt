package com.techcareer.nane.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.techcareer.nane.data.entity.*
import com.techcareer.nane.retrofit.FoodDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodDaoRepository(var foodDao: FoodDao) {

    var foodList: MutableLiveData<List<Food>>
    var foodInCartList: MutableLiveData<List<FoodInCart>>

    init {
        foodList = MutableLiveData()
        foodInCartList = MutableLiveData()
    }

    fun takeFood(): MutableLiveData<List<Food>> {
        return foodList
    }

    fun takeFoodInCart() : MutableLiveData<List<FoodInCart>> {
        return foodInCartList
    }

    fun getAllFood() {
        foodDao.allFood().enqueue(object : Callback<FoodResponse> {
            override fun onResponse(call: Call<FoodResponse>, response: Response<FoodResponse>) {
                val list = response.body()!!.foodList
                foodList.value = list
            }

            override fun onFailure(call: Call<FoodResponse>, t: Throwable) {}
        })
    }

    fun getAllFoodInCart(user_name: String) {
        foodDao.getAllFoodInCart(user_name).enqueue(object : Callback<FoodInCartResponse> {
            override fun onResponse(call: Call<FoodInCartResponse>, response: Response<FoodInCartResponse>) {
                val list = response.body()!!.foodInCartList
                foodInCartList.value = list
            }

            override fun onFailure(call: Call<FoodInCartResponse>, t: Throwable) {}
        })
    }

    fun deleteFoodInCart(cart_food_id : Int, user_name: String){
        foodDao.deleteFoodInCart(cart_food_id, user_name).enqueue(object : Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                val basari = response.body()!!.success
                val mesaj = response.body()!!.message
                Log.e("Kişi sil", "$basari - $mesaj")
                getAllFoodInCart(user_name)
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {}
        })
    }

    fun addToCart(
        food_name: String, food_image_name: String, food_price: Int, food_order_quantity: Int, user_name: String
    ) {
        foodDao.addFoodToCart(food_name, food_image_name, food_price, food_order_quantity, user_name)
            .enqueue(object : Callback<CRUDResponse> {
                override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                    val success = response.body()!!.success
                    val message = response.body()!!.message
                    Log.e("Add To Cart", "$success - $message")
                }

                override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {}
            })
    }

}