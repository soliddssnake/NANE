package com.techcareer.nane.data.entity

import com.google.gson.annotations.SerializedName

data class FoodResponse(
    @SerializedName("yemekler") var foodList: List<Food>, @SerializedName("success") var success: Int
)
