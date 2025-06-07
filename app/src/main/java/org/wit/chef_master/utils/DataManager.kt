package org.wit.chef_master.utils

import org.wit.chef_master.R
import org.wit.chef_master.models.Recipe

object DataManager {
  private val recipes = mutableListOf<Recipe>()

  init {
    // Initialize sample data
    recipes.addAll(listOf(
      Recipe(
        id = 1,
        name = "Stir-fried Pork with Chili",
        imageResId = R.drawable.lajiaochaorou,
        calories = 350,
        cookingTime = 15,
        tags = listOf(
          "Home-style Cooking",
          "Appetizing Dish"
        ),
        ingredients = listOf(
          "Pork 300g",
          "Green peppers 5",
          "Garlic 3 cloves",
          "Light soy sauce 2 tbsp",
          "Dark soy sauce 1 tbsp",
          "Cooking wine 1 tbsp"
        ),
        steps = listOf(
          "Slice pork and marinate with cooking wine and light soy sauce for 10 minutes",
          "Shred green peppers and slice garlic",
          "Heat oil in wok, stir-fry pork until color changes",
          "Add garlic slices and sauté until fragrant",
          "Add green peppers and stir-fry until cooked",
          "Season with dark soy sauce, stir evenly and serve"
        )
      ),
      Recipe(
        id = 2,
        name = "Tomato Scrambled Eggs",
        imageResId = R.drawable.fanqiechaodan,
        calories = 288,
        cookingTime = 10,
        tags = listOf("Home-style Cooking"),
        ingredients = listOf(
          "Tomatoes 2",
          "Eggs 3",
          "Salt to taste",
          "Sugar a pinch",
          "Chopped scallions a little"
        ),
        steps = listOf(
          "Cut tomatoes into chunks, beat eggs",
          "Heat oil in pan, scramble eggs until set then remove",
          "Reheat oil, stir-fry tomatoes",
          "When tomatoes soften, add scrambled eggs back in",
          "Season with salt and sugar, garnish with scallions"
        )
      ),
      Recipe(
        id = 3,
        name = "Steak",
        imageResId = R.drawable.niupai,
        calories = 159,
        cookingTime = 15,
        tags = listOf("Western Cuisine"),
        ingredients = listOf(
          "Steak 1 piece",
          "Salt to taste",
          "Black pepper to taste",
          "Rosemary a little",
          "Butter 1 tbsp"
        ),
        steps = listOf(
          "Remove steak from fridge and let rest at room temperature for 20 minutes",
          "Pat dry steak surface with paper towels",
          "Season both sides generously with salt and freshly ground black pepper",
          "Heat pan until smoking hot, add high smoke point oil",
          "Sear fatty edges first for about 30 seconds",
          "Cook first side for 1 minute 30 seconds (for 3cm thick steak)",
          "Flip and cook second side for 1 minute (medium-rare)",
          "Reduce heat, add butter, crushed garlic and fresh rosemary",
          "Tilt pan and baste steak with melted butter for 1 minute",
          "Let steak rest on warm plate for 5 minutes before slicing"
        )
      ),
      Recipe(
        id = 4,
        name = "Spaghetti Bolognese",
        imageResId = R.drawable.yidalimian,
        calories = 420,
        cookingTime = 30,
        tags = listOf("Western Cuisine", "Staple Food"),
        ingredients = listOf(
          "Spaghetti 200g",
          "Ground beef 150g",
          "Tomatoes 2",
          "Onion 1/2",
          "Minced garlic 2 cloves",
          "Tomato paste 3 tbsp",
          "Olive oil as needed",
          "Salt to taste",
          "Black pepper to taste"
        ),
        steps = listOf(
          "Boil salted water and cook pasta (1 minute less than package time)",
          "Blanch tomatoes to peel, dice; mince onion",
          "Sauté garlic and onion in olive oil until translucent",
          "Add ground beef and cook until browned",
          "Add tomatoes, tomato paste and 1/2 cup pasta water, simmer 15 minutes",
          "Season with salt and pepper",
          "Toss cooked pasta with sauce for 1 minute",
          "Serve with grated Parmesan cheese"
        )
      ),
      Recipe(
        id = 5,
        name = "Kung Pao Chicken",
        imageResId = R.drawable.gongbaojidin,
        calories = 380,
        cookingTime = 20,
        tags = listOf("Chinese Cuisine", "Sichuan Dish"),
        ingredients = listOf(
          "Chicken breast 300g",
          "Fried peanuts 50g",
          "Dried chili peppers 6",
          "Sichuan peppercorns 1 tsp",
          "Scallion whites 2",
          "Minced ginger 1 tsp",
          "Minced garlic 2 cloves",
          "Light soy sauce 2 tbsp",
          "Dark soy sauce 1/2 tbsp",
          "Vinegar 1 tbsp",
          "Sugar 1 tbsp",
          "Cooking wine 1 tbsp",
          "Cornstarch as needed"
        ),
        steps = listOf(
          "Dice chicken, marinate with wine, soy sauce and starch for 10 mins",
          "Make sauce: soy sauce + vinegar + sugar + starch + 2 tbsp water",
          "Fry peanuts in cool oil until golden, remove",
          "Stir-fry chili and peppercorns in hot oil (don't burn)",
          "Quickly stir-fry chicken until color changes",
          "Add aromatics (ginger, garlic, scallion)",
          "Pour in sauce and reduce over high heat",
          "Toss in peanuts before serving"
        )
      ),
      Recipe(
        id = 6,
        name = "Japanese Teriyaki Chicken Rice",
        imageResId = R.drawable.feiniufan,
        calories = 550,
        cookingTime = 25,
        tags = listOf("Japanese Cuisine", "Bento"),
        ingredients = listOf(
          "Chicken thighs 2",
          "Rice 1 bowl",
          "Soy sauce 3 tbsp",
          "Mirin 2 tbsp",
          "Sake 2 tbsp",
          "Honey 1 tbsp",
          "Ginger slices 3",
          "White sesame seeds as needed"
        ),
        steps = listOf(
          "Debone chicken, tenderize with back of knife, marinate with ginger",
          "Make teriyaki sauce: soy sauce + mirin + sake + honey",
          "Cook chicken skin-side down in cold pan until golden",
          "Flip and cook 3 minutes, blot excess oil",
          "Add sauce and simmer until thickened (about 5 mins)",
          "Slice and arrange over rice",
          "Drizzle with sauce, garnish with sesame seeds"
        )
      )
    ))
  }

  fun getRecipes(sortByCalories: Boolean = false): List<Recipe> {
    return recipes
  }

  // Get all unique tags
  fun getAllTags(): List<String> =
    recipes.flatMap { it.tags }.distinct()

  // Get recipes by tag
  fun getRecipesByTag(tag: String): List<Recipe> =
    recipes.filter { it.tags.contains(tag) }
}
