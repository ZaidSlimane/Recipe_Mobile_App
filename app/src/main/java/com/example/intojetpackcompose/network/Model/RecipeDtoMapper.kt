package com.example.intojetpackcompose.network.mdoel

import com.example.intojetpackcompose.domain.model.Meal
import com.example.intojetpackcompose.domain.util.DomainMapper

class RecipeDtoMapper : DomainMapper<RecipeDTO, Meal>{
    override fun mapToDomainModel(recipeDTO: RecipeDTO): Meal {
       val meal:Meal = Meal(
           recipeDTO.pk,
           recipeDTO.title,
           recipeDTO.publisher,
           recipeDTO.featured_image,
           recipeDTO.rating,
           recipeDTO.source_url,
           recipeDTO.description,
           recipeDTO.cooking_instructions,
           recipeDTO.ingredients,
           recipeDTO.date_added,
           recipeDTO.date_updated,
           recipeDTO.long_date_added,
           recipeDTO.long_date_updated
       )

        return meal
    }

    override fun mapToRecipeDTO(domainModel: Meal): RecipeDTO {

        val reicpeDto: RecipeDTO = RecipeDTO(
            domainModel.pk,
            domainModel.title,
            domainModel.publisher,
            domainModel.featured_image,
            domainModel.rating,
            domainModel.source_url,
            domainModel.description,
            domainModel.cooking_instructions,
            domainModel.ingredients,
            domainModel.date_added,
            domainModel.date_updated,
            domainModel.long_date_added,
            domainModel.long_date_updated
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

