package org.wit.chef_master.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.wit.chef_master.R
import org.wit.chef_master.activities.RecipeDetailActivity
import org.wit.chef_master.utils.DataManager

class CategoryAdapter(
    private val tags: List<String>,
    private val onRecipeClick: (Int) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tagName: TextView = itemView.findViewById(R.id.tagName)
        val recipesGrid: RecyclerView = itemView.findViewById(R.id.recipesGrid)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tag = tags[position]

        // 设置分类标签名
        holder.tagName.text = tag

        // 设置该分类下的菜品网格
        val recipes = DataManager.getRecipesByTag(tag)
        holder.recipesGrid.layoutManager = GridLayoutManager(holder.itemView.context, 4)
        holder.recipesGrid.adapter = RecipeAdapter(recipes, onRecipeClick)
    }

    override fun getItemCount() = tags.size
}