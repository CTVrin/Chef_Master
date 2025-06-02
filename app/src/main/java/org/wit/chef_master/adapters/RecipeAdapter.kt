package org.wit.chef_master.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.wit.chef_master.R
import org.wit.chef_master.models.Recipe
import org.wit.chef_master.utils.DataManager


class RecipeAdapter(
    private var recipes: List<Recipe>,
) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {
    // 定义点击回调（参数为图片ID）
    var onImageClick: ((imageId: Int) -> Unit)? = null


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.recipeImageView)
        val nameTextView: TextView = view.findViewById(R.id.recipeNameTextView)
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

        // 点击图片时回调
        holder.imageView.setOnClickListener {
            onImageClick?.invoke(recipe.id) // 传递菜品ID
        }
    }
    fun updateData(newData: List<Recipe>) {
        recipes=newData
        notifyDataSetChanged() // 触发UI刷新
    }

    override fun getItemCount() = recipes.size
}