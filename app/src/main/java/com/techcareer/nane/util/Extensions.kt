package com.techcareer.nane.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.moveIn(v:View,id:Int){
    findNavController(v).navigate(id)
}

fun Navigation.moveIn(v: View, id: NavDirections){
    findNavController(v).navigate(id)
}