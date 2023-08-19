package com.example.intojetpackcompose.network.RetrofitService

import com.example.intojetpackcompose.network.Response.RecipeSearchResponse
import com.example.intojetpackcompose.network.mdoel.RecipeDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeService {

    @GET("search.php")
    suspend fun get (
        @Query("s") query: String
    ) : RecipeSearchResponse

    @GET("lookup.php")
    suspend fun getById(
        @Query("i") id: Int
    ) : RecipeDTO

    @GET("search")
    suspend fun getRecipe(
        @Header("Authorization") token: String,
        @Query ("page") page: Int,
        @Query ("query") query : String
    ) : RecipeSearchResponse

    @GET("recipe/get/")
    suspend fun get(
        @Header("Authorization") token: String,
        @Query("id") id: Int
    ): RecipeDTO




}