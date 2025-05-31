package org.wit.chef_master.activities
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.wit.chef_master.R
import org.wit.chef_master.models.Recipe
import org.wit.chef_master.utils.DataManager

class RecipeDetailActivity : AppCompatActivity() {

    // 声明视图变量
    private lateinit var detailImageView: ImageView
    private lateinit var recipeNameTextView: TextView
    private lateinit var caloriesTextView: TextView
    private lateinit var favoriteButton: Button

    private lateinit var recipe: Recipe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        // 初始化视图
        initViews()

        // 获取传递的recipeId
        val recipeId = intent.getIntExtra("RECIPE_ID", -1)
        recipe = DataManager.getRecipes().find { it.id == recipeId } ?: run {
            finish()
            return
        }

        // 设置视图内容
        setupViews()
    }

    private fun initViews() {
        detailImageView = findViewById(R.id.detailImageView)
        recipeNameTextView = findViewById(R.id.recipeNameTextView)
        caloriesTextView = findViewById(R.id.caloriesTextView)
        favoriteButton = findViewById(R.id.favoriteButton)
    }

    private fun setupViews() {
        detailImageView.setImageResource(recipe.imageResId)
        recipeNameTextView.text = recipe.name
        caloriesTextView.text = "热量: ${recipe.calories} 卡路里"

        updateFavoriteButton()

        favoriteButton.setOnClickListener {
            DataManager.toggleFavorite(recipe.id)
            updateFavoriteButton()
        }
    }

    private fun updateFavoriteButton() {
        favoriteButton.text = if (recipe.isFavorite) {
            "已收藏"
        } else {
            "收藏"
        }
    }
}