package org.wit.chef_master.utils

import org.wit.chef_master.R
import org.wit.chef_master.models.Recipe

// DataManager.kt
object DataManager {
    private val recipes = mutableListOf<Recipe>()

    init {

        // 初始化示例数据
        recipes.addAll(listOf(
                Recipe(
                    id = 1,
                    name = "辣椒炒肉",
                    imageResId = R.drawable.lajiaochaorou, // 确保在res/drawable中有对应图片
                    calories = 350,
                    cookingTime =15,

                    tags= listOf(
                        "家常菜",
                        "下饭菜"
                    ),
                    ingredients = listOf(
                        "猪肉 300克",
                        "青椒 5个",
                        "大蒜 3瓣",
                        "生抽 2勺",
                        "老抽 1勺",
                        "料酒 1勺"
                    ),
                    steps = listOf(
                        "猪肉切片，用料酒、生抽腌制10分钟",
                        "青椒切丝，大蒜切片",
                        "热锅凉油，下肉片翻炒至变色",
                        "加入蒜片爆香",
                        "放入青椒翻炒至断生",
                        "加入老抽调味，翻炒均匀出锅"
                    )

                ),
                Recipe(
                    id = 2,
                    name = "番茄炒蛋",
                    imageResId = R.drawable.fanqiechaodan,
                    calories = 288,
                    cookingTime = 10,
                    tags = listOf("家常菜"),
                    ingredients = listOf(
                        "番茄 2个",
                        "鸡蛋 3个",
                        "盐 适量",
                        "糖 少许",
                        "葱花 少许"
                    ),
                    steps = listOf(
                        "番茄切块，鸡蛋打散",
                        "热锅凉油，先炒鸡蛋至凝固盛出",
                        "重新热油，下番茄翻炒",
                        "番茄炒软后加入炒好的鸡蛋",
                        "加盐、糖调味，撒葱花出锅"
                    )
                ),
                Recipe(
                    id=3,
                    name="煎牛排",
                    imageResId = R.drawable.niupai,
                    calories = 159,
                    cookingTime = 15,
                    tags = listOf("西餐"),
                    ingredients = listOf(
                        "牛排 1块",
                        "盐 适量",
                        "黑胡椒 适量",
                        "迷迭香 少许",
                        "黄油 1块"
                        ),
                    steps = listOf(
                        "将牛排从冰箱取出，室温静置20分钟回温",
                        "用厨房纸吸干牛排表面血水",
                        "在牛排两面均匀撒上海盐和现磨黑胡椒（现磨的更香）",
                        "平底锅大火烧至冒烟，倒入少量耐高温油（如牛油果油）",
                        "放入牛排，先煎带脂肪的侧边约30秒封边",
                        "将牛排平放，第一面煎1分30秒（3cm厚牛排为例）",
                        "用夹子翻面，第二面煎1分钟（三分熟标准）",
                        "转小火，加入黄油、大蒜（带皮拍碎）和新鲜迷迭香",
                        "倾斜锅身，用勺子将融化的黄油反复淋在牛排表面1分钟",
                        "将牛排放到温热的盘中静置5分钟（锁住肉汁）",
                        "静置后逆纹切片，撒上少许海盐和黑胡椒碎"
                    )

                ),
                Recipe(
                    id = 4,
                    name= "意式番茄肉酱面",
                    imageResId = R.drawable.yidalimian,
                    calories = 420,
                    cookingTime = 30,
                    tags = listOf("西餐", "主食"),
                    ingredients = listOf(
                        "意大利面 200g",
                        "牛肉末 150g",
                        "番茄 2个",
                        "洋葱 1/2个",
                        "蒜末 2瓣",
                        "番茄酱 3大勺",
                        "橄榄油 适量",
                        "盐 适量",
                        "黑胡椒 适量"
                    ),
                    steps = listOf(
                        "深锅烧开水，加盐煮意面（包装时间减1分钟）",
                        "番茄划十字烫去皮，切小丁；洋葱切末",
                        "平底锅倒橄榄油，炒香蒜末和洋葱至透明",
                        "加入牛肉末炒散至变色",
                        "放入番茄丁炒软，加番茄酱和半杯面汤熬煮15分钟",
                        "收汁至浓稠，加盐、黑胡椒调味",
                        "将煮好的意面放入酱汁中翻炒1分钟",
                        "装盘后擦上帕玛森芝士碎"
                    ) ),
                Recipe(
                    id = 5,
                    name = "宫保鸡丁",
                    imageResId = R.drawable.gongbaojidin,
                    calories = 380,
                    cookingTime = 20,
                    tags = listOf("中餐", "川菜"),
                    ingredients = listOf(
                        "鸡胸肉 300g",
                        "油炸花生米 50g",
                        "干辣椒 6个",
                        "花椒 1小把",
                        "葱白 2根",
                        "姜末 1茶匙",
                        "蒜末 2瓣",
                        "生抽 2勺",
                        "老抽 1/2勺",
                        "香醋 1勺",
                        "白糖 1勺",
                        "料酒 1勺",
                        "淀粉 适量"
                    ),
                    steps = listOf(
                        "鸡胸肉切1.5cm丁，用料酒、生抽、淀粉腌10分钟",
                        "调宫保汁：生抽+老抽+醋+糖+淀粉+2勺水",
                        "冷油下花生米小火炸至微黄捞出",
                        "热锅凉油爆香干辣椒和花椒（注意别糊）",
                        "下鸡丁快速滑炒至变色",
                        "加入葱姜蒜末炒香",
                        "倒入调好的酱汁大火收汁",
                        "最后撒花生米翻匀出锅"
                    )),
                Recipe(
                    id = 6,
                    name = "日式照烧鸡腿饭",
                    imageResId = R.drawable.feiniufan,
                    calories = 550,
                    cookingTime = 25,
                    tags = listOf("日料", "便当"),
                    ingredients = listOf(
                        "鸡腿 2只",
                        "米饭 1碗",
                        "生抽 3勺",
                        "味醂 2勺",
                        "清酒 2勺",
                        "蜂蜜 1勺",
                        "姜片 3片",
                        "白芝麻 适量"
                    ),
                    steps = listOf(
                        "鸡腿去骨，用刀背拍松，姜片腌10分钟",
                        "调照烧汁：生抽+味醂+清酒+蜂蜜",
                        "鸡皮朝下放入冷锅，中小火煎至金黄",
                        "翻面煎3分钟，用厨房纸吸掉多余油脂",
                        "倒入照烧汁，中小火煮至酱汁浓稠（约5分钟）",
                        "取出切块，摆在米饭上",
                        "淋上剩余酱汁，撒白芝麻和葱花"
                    )
                )
                ))

    }

    fun getRecipes(sortByCalories: Boolean = false): List<Recipe> {

        return recipes

    }
    // 获取所有分类标签（去重）
    fun getAllTags(): List<String> =
        recipes.flatMap { it.tags }.distinct()
    // 根据标签获取菜品
    fun getRecipesByTag(tag: String): List<Recipe> =
        recipes.filter { it.tags.contains(tag) }

}