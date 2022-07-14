package com.techcareer.nane.retrofit

import com.techcareer.nane.data.entity.FoodResponse
import retrofit2.Call
import retrofit2.http.GET

interface FoodDao {

    @GET("yemekler/tumYemekleriGetir.php")
    fun allFood(): Call<FoodResponse>

}