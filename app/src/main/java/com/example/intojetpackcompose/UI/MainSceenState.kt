package com.example.intojetpackcompose.UI
import com.example.intojetpackcompose.domain.model.Meal

data class MainSceenState(
    var onLunchRecipeData: List<Meal> = emptyList(),
    var isLoading: Boolean = true,
    var error : String = ""
)