package com.example.intojetpackcompose.di

import com.example.intojetpackcompose.network.RetrofitService.ApiService
import com.example.intojetpackcompose.network.RetrofitService.RecipeService
import com.example.intojetpackcompose.network.mdoel.RecipeDtoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


    @Module
    @InstallIn(SingletonComponent::class)
    object NetworkModule {

        @Singleton
        @Provides
        fun provideRecipeMapper(): RecipeDtoMapper {
            return RecipeDtoMapper()
        }
        @Singleton
        @Provides
        fun provideRetrofitService(): RecipeService {
            return ApiService.recipeSevice
        }

    }
