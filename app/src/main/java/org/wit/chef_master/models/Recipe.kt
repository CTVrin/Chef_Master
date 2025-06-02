package org.wit.chef_master.models

data class Recipe(
    val id: Int,
    val name: String,
    val imageResId: Int,
    val calories: Int,
    var isFavorite: Boolean = false,
    var cookingTime:Int
)