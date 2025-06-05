package org.wit.chef_master.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.wit.chef_master.R
import org.wit.chef_master.models.Recipe
import org.wit.chef_master.utils.TodayMenuManager

class DishQuantityAdapter(
    var dishes: List<Pair<Recipe, Int>>,
    private val onQuantityChanged: () -> Unit,
    private val totalCaloriesChanged:()->Unit
) : RecyclerView.Adapter<DishQuantityAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(recipe: Recipe, quantity: Int) {
            itemView.apply {
                findViewById<ImageView>(R.id.dishImage).setImageResource(recipe.imageResId)
                findViewById<TextView>(R.id.dishName).text = recipe.name
                findViewById<TextView>(R.id.tvQuantity).text = quantity.toString()

                // 减少份数按钮
                findViewById<Button>(R.id.btnDecrease).setOnClickListener {
                    val removed = TodayMenuManager.decreaseQuantity(recipe)
                    if (removed) {
                        onQuantityChanged()
                    } else {
                        findViewById<TextView>(R.id.tvQuantity).text =
                            (TodayMenuManager.getAllDishes().first { it.first == recipe }.second).toString()
                    }
                    totalCaloriesChanged()
                }

                // 增加份数按钮
                findViewById<Button>(R.id.btnIncrease).setOnClickListener {

                    TodayMenuManager.addRecipe(recipe)
                    findViewById<TextView>(R.id.tvQuantity).text =
                        (TodayMenuManager.getAllDishes().first { it.first == recipe }.second).toString()
                    totalCaloriesChanged()
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dish_with_quantity, parent, false) // 这里确定XML文件
            return ViewHolder(view)
        }


    override fun getItemCount(): Int {
        return dishes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val(recipe,quantity)=dishes[position]
        holder.bind(recipe,quantity)
    }

    // ... 其他必要方法 ...
}