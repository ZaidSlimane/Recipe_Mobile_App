package com.example.intojetpackcompose.network.mdoel

import com.example.intojetpackcompose.domain.model.Meal
import com.example.intojetpackcompose.domain.util.DomainMapper

class RecipeDtoMapper : DomainMapper<RecipeDTO, Meal>{
    override fun mapToDomainModel(recipeDTO: RecipeDTO): Meal {
       val meal:Meal = Meal(
           recipeDTO.title,
           recipeDTO.featured_image,
           recipeDTO.rating,
           recipeDTO.source_url,
           recipeDTO.description,
           recipeDTO.cooking_instructions,
           recipeDTO.ingredients
       )

        return meal
    }

    override fun mapToRecipeDTO(domainModel: Meal): RecipeDTO {

        val reicpeDto: RecipeDTO = RecipeDTO(
            null,
            domainModel.title,
            null,
            domainModel.featured_image,
            domainModel.rating,
            domainModel.source_url,
            domainModel.description,
            domainModel.cooking_instructions,
            domainModel.ingredients,
            null,
            null,
        )

        return reicpeDto
    }


    fun fromDtoList(initial: List<RecipeDTO>): List<Meal>{
        return initial.map { mapToDomainModel(it) }
    }

    fun toDtoList(initial: List<Meal>): List<RecipeDTO>{
        return initial.map { mapToRecipeDTO(it) }
    }


}

