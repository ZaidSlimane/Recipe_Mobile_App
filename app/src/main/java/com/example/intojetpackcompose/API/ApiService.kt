package com.example.intojetpackcompose.API

import com.example.intojetpackcompose.network.mdoel.RrecipeApi
import javax.inject.Inject


class ApiService @Inject constructor(
    private val recipesApi: RrecipeApi
){

}