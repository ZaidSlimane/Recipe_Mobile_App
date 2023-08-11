package com.example.intojetpackcompose.API

import com.example.intojetpackcompose.network.mdoel.RrecipeApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object RetrofitClient {
    private const val BASE_URL = " www.themealdb.com/api/json/v1/1/random.php"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val apiService : RrecipeApi = retrofit.create(RrecipeApi::class.java)

}