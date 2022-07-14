package com.techcareer.nane.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.techcareer.nane.data.entity.Food
import com.techcareer.nane.data.repo.FoodDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainPageFragmentViewModel @Inject constructor(var frepo: FoodDaoRepository) : ViewModel() {

    var foodList = MutableLiveData<List<Food>>()

    init {
        uploadFood()
        foodList = frepo.takeFood()
    }

    fun uploadFood() {
        frepo.getAllFood()
    }

}