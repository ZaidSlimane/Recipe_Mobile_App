package com.example.intojetpackcompose.ViewModel

import com.example.intojetpackcompose.domain.model.Meal

data class FirstAccessState(
    val mealTitle: List<Meal>,
    val mealThumb: String
        )