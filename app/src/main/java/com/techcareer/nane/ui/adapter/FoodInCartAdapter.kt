package com.techcareer.nane.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.techcareer.nane.R
import com.techcareer.nane.data.entity.FoodInCart
import com.techcareer.nane.databinding.FoodInCartCardBinding
import com.techcareer.nane.retrofit.ApiUtils.Companion.BASE_URL

class FoodInCartAdapter(var mContext: Context, var foodInCartList: List<FoodInCart>) :
    RecyclerView.Adapter<FoodInCartAdapter.FoodInCartCardViewHolder>() {
    inner class FoodInCartCardViewHolder(binding: FoodInCartCardBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: FoodInCartCardBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodInCartCardViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: FoodInCartCardBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.food_in_cart_card, parent, false)
        return FoodInCartCardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return foodInCartList.size
    }

    override fun onBindViewHolder(holder: FoodInCartCardViewHolder, position: Int) {
        val foodInCart = foodInCartList[position]
        val b = holder.binding
        b.foodInCartObject = foodInCart

        Picasso.get().load(BASE_URL + "yemekler/resimler/" + foodInCart.food_image_name).into(b.imageViewFoodInCart)


    }
}