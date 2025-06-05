package org.wit.chef_master.activities

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.imageview.ShapeableImageView
import org.wit.chef_master.R
import org.wit.chef_master.utils.DataManager
import org.wit.chef_master.utils.TodayMenuManager

class RecipeDetailActivity : AppCompatActivity() {
    private var isFavorite= false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val recipeId = intent.getIntExtra("RECIPE_ID", -1)
        if (recipeId == -1) {
            finish()
            return
        }

        val recipe = DataManager.getRecipes(false).find { it.id == recipeId }
        if (recipe == null) {
            finish()
            return
        }
        //设置封面
        findViewById<ShapeableImageView>(R.id.detailImageView).setImageResource(recipe.imageResId)

        // 设置菜谱标题
        findViewById<TextView>(R.id.recipeNameTextView).text = recipe.name
        //设置热量
        findViewById<TextView>(R.id.caloriesTextView).text = "热量：" + recipe.calories + "卡路里"

        // 添加食材
        val ingredientsContainer = findViewById<TextView>(R.id.ingredientsTextView)

        val formattedIngredients = recipe.ingredients.mapIndexed { index, ingredient ->
            "${index + 1}. $ingredient"
        }.joinToString("\n")
        ingredientsContainer.text = formattedIngredients
        //添加做法
        val stepsContainer = findViewById<TextView>(R.id.stepsTextView)
        val formattedSteps = recipe.steps.mapIndexed { index, step ->
            "${index + 1}. $step"
        }.joinToString("\n")
        stepsContainer.text = formattedSteps
        // 收藏按钮点击事件

        val favoriteButton = findViewById<ImageButton>(R.id.favoriteButton)
        favoriteButton.setOnClickListener {
            TodayMenuManager.addRecipe(recipe,1)
            Toast.makeText(this, "添加一份到今日菜谱", Toast.LENGTH_SHORT).show()
        }
    }


}