package com.techcareer.nane.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.techcareer.nane.R
import com.techcareer.nane.data.entity.Food
import com.techcareer.nane.databinding.FoodCardBinding
import com.techcareer.nane.retrofit.ApiUtils.Companion.BASE_URL
import com.techcareer.nane.ui.fragment.MainPageFragmentDirections
import com.techcareer.nane.util.moveIn

class FoodAdapter(var mContext: Context, var foodList: List<Food>) :
    RecyclerView.Adapter<FoodAdapter.CardViewHolder>() {
    inner class CardViewHolder(binding: FoodCardBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: FoodCardBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: FoodCardBinding = DataBindingUtil.inflate(layoutInflater, R.layout.food_card, parent, false)
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val food = foodList[position]
        val b = holder.binding
        b.foodObject = food

        Picasso.get().load(BASE_URL + "yemekler/resimler/" + food.food_image_name).into(b.imageView)

        b.cardRow.setOnClickListener {
            val pass = MainPageFragmentDirections.toFoodDetail(food = food)
            Navigation.moveIn(it, pass)
        }
    }
}