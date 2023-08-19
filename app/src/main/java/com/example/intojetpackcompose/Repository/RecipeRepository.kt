package com.example.intojetpackcompose.Repository

import com.example.intojetpackcompose.domain.model.Meal
import com.example.intojetpackcompose.network.Response.RecipeSearchResponse
import com.example.intojetpackcompose.network.mdoel.RecipeDTO

interface RecipeRepository {
    suspend fun getRecipeWithQuery(authorizationCode : String,
                                   page: String,
                                   query: String): RecipeSearchResponse
    suspend fun getRecipeWithId(): List<Meal>


}