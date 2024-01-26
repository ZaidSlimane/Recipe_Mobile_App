package com.example.intojetpackcompose.di

import com.example.intojetpackcompose.Repository.RecipeRepository
import com.example.intojetpackcompose.Repository.RecipeRepositoryImpl
import com.example.intojetpackcompose.network.RetrofitService.ApiService
import com.example.intojetpackcompose.network.RetrofitService.RecipeService
import com.example.intojetpackcompose.network.mdoel.RecipeDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

class RepositoryModule {

    @Module
    @InstallIn(SingletonComponent::class)
    object RepositoryModule {

        @Singleton
        @Provides
        fun provideRecipeRepository(
            recipeService: RecipeService,
            recipeMapper: RecipeDtoMapper,
        ): RecipeRepository {
            return RecipeRepositoryImpl(
                apiService = recipeService,
                dtoMapper = recipeMapper
            )
        }
    }
}