package org.wit.chef_master.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.imageview.ShapeableImageView
import org.wit.chef_master.R
import org.wit.chef_master.utils.DataManager

class RecipeDetailActivity : AppCompatActivity() {

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
        val stepsContainer=findViewById<TextView>(R.id.stepsTextView)
        val formattedSteps=recipe.steps.mapIndexed { index, step ->
            "${index + 1}. $step"
        }.joinToString("\n")
        stepsContainer.text=formattedSteps
        /*
// 设置到TextView
        stepsTextView.text = formattedSteps
        recipe.ingredients.forEach { ingredient ->
            val textView = TextView(this).apply {
                text = "• $ingredient"
                textSize = 16f
                setPadding(0, 4, 0, 4)
            }
            ingredientsContainer.addView(textView)
        }

        // 添加步骤
        val stepsContainer = findViewById<LinearLayout>(R.id.stepsContainer)
        dish.steps.forEachIndexed { index, step ->
            val textView = TextView(this).apply {
                text = "${index + 1}. $step"
                textSize = 16f
                setPadding(0, 4, 0, 4)
            }
            stepsContainer.addView(textView)
        }

        // 设置其他信息
        findViewById<TextView>(R.id.cookingTimeTextView).text = "烹饪时间: ${dish.cookingTime}"
        findViewById<TextView>(R.id.difficultyTextView).text = "难度: ${dish.difficulty}"
    }

 */
    }
}