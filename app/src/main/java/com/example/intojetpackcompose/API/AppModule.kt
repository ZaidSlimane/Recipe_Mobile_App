package com.example.intojetpackcompose.API

import com.example.intojetpackcompose.network.mdoel.RrecipeApi
import com.google.android.datatransport.runtime.dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.moshi.MoshiConverterFactory


    object AppModule {

        @Provides
        @Singleton
        fun provideApi(builder: Retrofit.Builder): RrecipeApi {
            return builder
                .build()
                .create(RrecipeApi::class.java)
        }

        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit.Builder{
            return Retrofit.Builder()
                .baseUrl("www.themealdb.com/api/json/v1/1/random.php")
                .addConverterFactory(MoshiConverterFactory.create())
        }
    }
