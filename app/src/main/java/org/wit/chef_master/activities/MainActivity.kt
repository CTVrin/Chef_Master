package org.wit.chef_master.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import org.wit.chef_master.R
import org.wit.chef_master.adapters.CategoryAdapter
import org.wit.chef_master.adapters.RecipeAdapter
import org.wit.chef_master.models.Recipe
import org.wit.chef_master.utils.DataManager

class MainActivity : AppCompatActivity() {

    // 声明所有视图变量
    private lateinit var searchView: SearchView
    private lateinit var todayRecipeButton: Button
    private lateinit var tabLayout: TabLayout
    private lateinit var sortButton: Button
    private lateinit var recipesRecyclerView: RecyclerView
    private lateinit var adapter: RecipeAdapter
    private lateinit var searchResults: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 初始化所有视图
        initViews()
        loadRecipes()
        setupViews()
      // 在onCreate()中添加以下代码
      val searchView = findViewById<SearchView>(R.id.searchView)
      val results = findViewById<RecyclerView>(R.id.recipesRecyclerView) // 复用您原有的列表

      searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?) = true
        override fun onQueryTextChange(newText: String?): Boolean {

          // 过滤出包含搜索词的食谱
          val filtered = if (newText.isNullOrEmpty()) {
            emptyList<Recipe>()
          } else {
            DataManager.getRecipes(false).filter { recipe ->
              recipe.name.contains(newText, ignoreCase = true)
            }
          }

          // 更新显示
          results.adapter = RecipeAdapter(filtered) {}
          return true
        }
      })


        // 排序按钮点击事件
        findViewById<Button>(R.id.sortButton).setOnClickListener {
            showSortDialog()
        }
    }

    private fun initViews() {
        searchView = findViewById(R.id.searchView)
        todayRecipeButton = findViewById(R.id.todayRecipeButton)
        tabLayout = findViewById(R.id.tabLayout)
        sortButton = findViewById(R.id.sortButton)
        recipesRecyclerView = findViewById(R.id.recipesRecyclerView)
    }

    private fun setupViews() {




        // 设置TabLayout
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> loadRecipes() // 推荐
                    1 -> showCategories() // 分类
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })


        // 今日菜谱按钮点击事件
        todayRecipeButton.setOnClickListener {
            // 今日菜谱逻辑
            startActivity(Intent(this, TodayMenuActivity::class.java))

        }
    }

    private fun showSortDialog() {
        val options = arrayOf("sort by calories", "sort by cooking time")

        AlertDialog.Builder(this)
            .setTitle("select the way to sort")
            .setItems(options) { _, which ->
                when (which) {
                    0 -> sortByCalories()
                    1 -> sortByCookingTime()
                }
            }
            .show()
    }

    private fun sortByCalories() {
        val sortButton = findViewById<Button>(R.id.sortButton)
        sortButton.text = "sort by calories"
        val sorted = DataManager.getRecipes(false).sortedBy { it.calories }
        adapter.updateData(sorted)
    }

    private fun sortByCookingTime() {
        val sortButton = findViewById<Button>(R.id.sortButton)
        sortButton.text = "sort by cooking time"
        val sorted = DataManager.getRecipes(false).sortedBy { it.cookingTime }
        adapter.updateData(sorted)
    }


    private fun loadRecipes() {
        // 加载菜谱逻辑
        recipesRecyclerView = findViewById(R.id.recipesRecyclerView)
        recipesRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecipeAdapter(DataManager.getRecipes(false).sortedBy { it.calories }, { imageId ->
            // 跳转并传递ID
            startActivity(Intent(this, RecipeDetailActivity::class.java).apply {
                putExtra("RECIPE_ID", imageId)
            })
        })
        recipesRecyclerView.adapter = adapter

    }

    private fun showCategories() {
        // 显示分类界面
        recipesRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CategoryAdapter(
            tags = DataManager.getAllTags(), { imageId ->
                // 跳转并传递ID
                startActivity(Intent(this, RecipeDetailActivity::class.java).apply {
                    putExtra("RECIPE_ID", imageId)
                }
                )
            })
        recipesRecyclerView.adapter=adapter

    }
}
