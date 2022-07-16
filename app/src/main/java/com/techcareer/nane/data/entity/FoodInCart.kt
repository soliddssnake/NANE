package com.techcareer.nane.data.entity

data class FoodInCart(
    var cart_food_id: Int,
    var food_name: String,
    var food_image_name: String,
    var food_price: Int,
    var food_order_quantity: Int,
    var user_name: String = "ibrahimengin"
)