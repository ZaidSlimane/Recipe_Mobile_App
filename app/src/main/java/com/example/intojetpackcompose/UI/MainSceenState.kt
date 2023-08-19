package com.example.intojetpackcompose.UI
import com.example.intojetpackcompose.domain.model.Meal

data class MainSceenState(
    var onLunchRecipeData: List<Meal> = emptyList(),
    var isLoading: Boolean = false,
    var error : String = ""
)