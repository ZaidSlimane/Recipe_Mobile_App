package com.example.intojetpackcompose.domain.util

interface DomainMapper <RecipeDTO, Meal>{

    fun mapToDomainModel(recipeDTO : RecipeDTO) : Meal
    fun mapToRecipeDTO(domainModel : Meal) : RecipeDTO


}