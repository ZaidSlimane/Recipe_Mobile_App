package com.example.intojetpackcompose.network.mdoel

import com.example.intojetpackcompose.domain.model.Meal
import com.example.intojetpackcompose.network.mdoel.RecipeDTO
import retrofit2.Response
import retrofit2.http.GET

interface RrecipeApi {
    @GET("www.themealdb.com/api/json/v1/1/random.php")
    suspend fun getRandomRecipes() : List<RecipeDTO>


    @GET("")
    suspend fun getRecipeDetails() : Response<List<Meal>>
}