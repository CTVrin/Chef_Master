package org.wit.chef_master.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.wit.chef_master.R
import org.wit.chef_master.models.Recipe

class RecipeAdapter(
    private var recipes: List<Recipe>,
    private val onRecipeClick: (Int) -> Unit // 点击回调通过构造函数传入
) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    // ViewHolder 定义（不变）
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.recipeImageView)
        val nameTextView: TextView = itemView.findViewById(R.id.recipeNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.imageView.setImageResource(recipe.imageResId)
        holder.nameTextView.text = recipe.name

        // 直接使用构造函数传入的回调
        holder.imageView.setOnClickListener {
            onRecipeClick(recipe.id) // 触发外部传入的回调
        }
    }

    fun updateData(newData: List<Recipe>) {
        recipes=newData
        notifyDataSetChanged() // 触发UI刷新
    }

    override fun getItemCount() = recipes.size


}