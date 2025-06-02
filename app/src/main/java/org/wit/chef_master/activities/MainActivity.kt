package org.wit.chef_master.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import org.wit.chef_master.R
import org.wit.chef_master.adapters.RecipeAdapter
import org.wit.chef_master.utils.DataManager

class MainActivity : AppCompatActivity() {

    // 声明所有视图变量
    private lateinit var searchEditText: EditText
    private lateinit var todayRecipeButton: Button
    private lateinit var tabLayout: TabLayout
    private lateinit var sortButton: Button
    private lateinit var recipesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recipesRecyclerView = findViewById(R.id.recipesRecyclerView)
        recipesRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter=RecipeAdapter(DataManager.getRecipes(true))
        adapter.onImageClick= { imageId ->
            // 跳转并传递ID
            startActivity(Intent(this, RecipeDetailActivity::class.java).apply {
                putExtra("RECIPE_ID", imageId)
            })
        }
        recipesRecyclerView.adapter =adapter
        // 初始化所有视图
        initViews()


    }

    private fun initViews() {
        searchEditText = findViewById(R.id.searchEditText)
        todayRecipeButton = findViewById(R.id.todayRecipeButton)
        tabLayout = findViewById(R.id.tabLayout)
        sortButton = findViewById(R.id.sortButton)
        recipesRecyclerView = findViewById(R.id.recipesRecyclerView)
    }

    private fun setupViews() {
        // 设置TabLayout
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position) {
                    0 -> loadRecipes() // 推荐
                    1 -> showCategories() // 分类
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })

        // 排序按钮点击事件
        sortButton.setOnClickListener {
            // 排序逻辑

        }

        // 今日菜谱按钮点击事件
        todayRecipeButton.setOnClickListener {
            // 今日菜谱逻辑
        }
    }

    private fun loadRecipes() {
        // 加载菜谱逻辑
    }

    private fun showCategories() {
        // 分类显示逻辑
    }
}