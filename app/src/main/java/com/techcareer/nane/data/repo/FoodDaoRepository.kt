package com.techcareer.nane.data.repo

import androidx.lifecycle.MutableLiveData
import com.techcareer.nane.data.entity.Food
import com.techcareer.nane.data.entity.FoodResponse
import com.techcareer.nane.retrofit.FoodDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodDaoRepository(var foodDao: FoodDao) {

    var foodList: MutableLiveData<List<Food>>

    init {
        foodList = MutableLiveData()
    }

    fun takeFood(): MutableLiveData<List<Food>> {
        return foodList
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

}