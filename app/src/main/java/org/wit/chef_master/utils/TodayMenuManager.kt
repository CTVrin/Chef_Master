package org.wit.chef_master.utils

import org.wit.chef_master.models.Recipe
object TodayMenuManager {
// 核心数据结构：Recipe对象为Key，Int为菜量
private val menuMap = mutableMapOf<Recipe, Int>()

// 添加/更新菜品（自动覆盖相同Recipe）
    fun addRecipe(recipe: Recipe, quantity: Int = 1) {
        menuMap[recipe] = menuMap.getOrDefault(recipe, 0) + quantity
    }
    fun decreaseQuantity(recipe: Recipe): Boolean {
        menuMap[recipe]?.let { current ->
            if (current > 1) {
                menuMap[recipe] = current - 1
                return false
            } else {
                menuMap.remove(recipe)
                return true
            }
        }
        return false
    }
    // 获取当前所有菜品（按添加顺序）
    fun getAllDishes(): List<Pair<Recipe, Int>> {
        return menuMap.entries.map { it.key to it.value }
    }
    fun getTotalCalories(): Int {
        return menuMap.entries.sumOf { (recipe,quantity)->recipe.calories*quantity }
    }


}