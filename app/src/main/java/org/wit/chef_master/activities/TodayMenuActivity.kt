package org.wit.chef_master.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.wit.chef_master.R
import org.wit.chef_master.adapters.DishQuantityAdapter
import org.wit.chef_master.utils.TodayMenuManager

class TodayMenuActivity : AppCompatActivity() {
    private lateinit var adapter: DishQuantityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today_menu)
        updateTotalCalories()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        adapter = DishQuantityAdapter(
            dishes = TodayMenuManager.getAllDishes(),
            onQuantityChanged =  {
                // 当菜品被移除时刷新列表
                adapter.dishes = TodayMenuManager.getAllDishes()
                adapter.notifyDataSetChanged()
            },
            totalCaloriesChanged = {
                // 当总热量变化时更新顶部统计UI
                updateTotalCalories()
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun updateTotalCalories() {
        findViewById<TextView>(R.id.tvTotalCalories).text =
            "Total Calories：${TodayMenuManager.getTotalCalories()} kcal"
    }

    override fun onResume() {
        super.onResume()
        // 返回时刷新数据
        adapter.dishes = TodayMenuManager.getAllDishes()
        adapter.notifyDataSetChanged()
    }
}
