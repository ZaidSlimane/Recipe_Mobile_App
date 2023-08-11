package com.example.intojetpackcompose.network.mdoel.RecipesRepo

import com.example.intojetpackcompose.network.mdoel.RecipeDTO
import com.example.intojetpackcompose.network.mdoel.RrecipeApi
import javax.inject.Inject

class repo @Inject constructor(
    private val recipesApi: RrecipeApi
) {
    suspend fun getRecipes(): List<RecipeDTO> {
        return recipesApi.getRandomRecipes()
    }
}