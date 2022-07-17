package com.techcareer.nane.data.entity

import com.google.gson.annotations.SerializedName

data class FoodInCartResponse(
    @SerializedName("sepet_yemekler") var foodInCartList: List<FoodInCart>, @SerializedName("success") var success: Int
)
