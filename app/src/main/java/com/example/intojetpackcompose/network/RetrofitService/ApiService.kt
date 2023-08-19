package com.example.intojetpackcompose.network.RetrofitService

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    val service = Retrofit.Builder()
        .baseUrl("https://food2fork.ca/api/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
        .create(RecipeService::class.java)

    suspend fun getRecipeData (token: String, id: Int){
        service.get(token, id)
    }



}