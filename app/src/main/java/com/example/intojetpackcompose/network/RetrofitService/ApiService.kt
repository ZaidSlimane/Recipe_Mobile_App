package com.example.intojetpackcompose.network.RetrofitService

import com.google.gson.GsonBuilder
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


object ApiService {

    val retrofitService = Retrofit.Builder()
        .baseUrl("https://food2fork.ca/api/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    val recipeSevice = retrofitService.create(RecipeService::class.java)

    suspend fun getRecipeData (token: String, id: Int){
        recipeSevice.get(token, id)
    }



}