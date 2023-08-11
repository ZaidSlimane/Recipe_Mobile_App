package com.example.intojetpackcompose.network.Response

import com.example.intojetpackcompose.network.mdoel.RecipeDTO
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(
    @SerializedName("results")
    var recipes : List<RecipeDTO>
)