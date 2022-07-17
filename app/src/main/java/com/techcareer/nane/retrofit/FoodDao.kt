package com.techcareer.nane.retrofit

import com.techcareer.nane.data.entity.CRUDResponse
import com.techcareer.nane.data.entity.FoodInCartResponse
import com.techcareer.nane.data.entity.FoodResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodDao {

    @GET("yemekler/tumYemekleriGetir.php")
    fun allFood(): Call<FoodResponse>

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun addFoodToCart(
        @Field("yemek_adi") food_name: String,
        @Field("yemek_resim_adi") food_image_name: String,
        @Field("yemek_fiyat") food_price: Int,
        @Field("yemek_siparis_adet") food_order_quantity: Int,
        @Field("kullanici_adi") user_name: String
    ): Call<CRUDResponse>

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun getAllFoodInCart(
        @Field("kullanici_adi") user_name: String
    ): Call<FoodInCartResponse>
    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun deleteFoodInCart(
        @Field("sepet_yemek_id") cart_food_id: Int,
        @Field("kullanici_adi") user_name: String
    ) : Call<CRUDResponse>

    @POST()
    fun updateFoodQuantity(
        @Field("sepet_yemek_id") cart_food_id: Int,
        @Field("yemek_siparis_adet") food_order_quantity: Int
    ) : Call<CRUDResponse>

}