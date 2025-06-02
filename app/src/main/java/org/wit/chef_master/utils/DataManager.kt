package org.wit.chef_master.utils

import org.wit.chef_master.R
import org.wit.chef_master.models.Recipe

// DataManager.kt
object DataManager {
    private val recipes = mutableListOf<Recipe>()

    init {
        // 初始化示例数据
        recipes.addAll(listOf(
            Recipe(1, "辣椒炒肉", R.drawable.lajiaochaorou, 350,false,15),
            Recipe(2, "槐花炒蛋", R.drawable.huaihuachaodan, 280,false,20),
            Recipe(3, "煎牛排", R.drawable.niupai, 450,false,30)
        ))
    }

    fun getRecipes(sortByCalories: Boolean = false): List<Recipe> {

        return recipes

    }


}