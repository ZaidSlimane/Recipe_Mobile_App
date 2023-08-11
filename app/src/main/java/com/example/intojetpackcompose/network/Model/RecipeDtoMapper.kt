package com.example.intojetpackcompose.network.mdoel

import com.example.intojetpackcompose.domain.model.Meal
import com.example.intojetpackcompose.domain.util.DomainMapper

/*class RecipeDtoMapper : DomainMapper<RecipeDTO, Meal>{
    override fun mapToDomainModel(recipeDTO: RecipeDTO): Meal {
       val meal:Meal = Meal(
           recipeDTO.idMeal,
           recipeDTO.strMeal,
           recipeDTO.strDrinkAlternate,
           recipeDTO.strCategory,
           recipeDTO.strArea,
           recipeDTO.strInstructions,
           recipeDTO.strMealThumb,
           recipeDTO.strTags,
           recipeDTO.strYoutube,
           recipeDTO.strIngredient1,
           recipeDTO.strIngredient2,
           recipeDTO.strIngredient3,
           recipeDTO.strIngredient4,
           recipeDTO.strIngredient5,
           recipeDTO.strIngredient6,
           recipeDTO.strIngredient7,
           recipeDTO.strIngredient8,
           recipeDTO.strIngredient9,
           recipeDTO.strIngredient10,
           recipeDTO.strIngredient11,
           recipeDTO.strIngredient12,
           recipeDTO.strIngredient13,
           recipeDTO.strIngredient14,
           recipeDTO.strIngredient15,
           recipeDTO.strIngredient16,
           recipeDTO.strIngredient17,
           recipeDTO.strIngredient18,
           recipeDTO.strIngredient19,
           recipeDTO.strIngredient20,
           recipeDTO.strMeasure1,
           recipeDTO.strMeasure2,
           recipeDTO.strMeasure3,
           recipeDTO.strMeasure4,
           recipeDTO.strMeasure5,
           recipeDTO.strMeasure6,
           recipeDTO.strMeasure7,
           recipeDTO.strMeasure8,
           recipeDTO.strMeasure9,
           recipeDTO.strMeasure10,
           recipeDTO.strMeasure11,
           recipeDTO.strMeasure12,
           recipeDTO.strMeasure13,
           recipeDTO.strMeasure14,
           recipeDTO.strMeasure15,
           recipeDTO.strMeasure16,
           recipeDTO.strMeasure17,
           recipeDTO.strMeasure18,
           recipeDTO.strMeasure19,
           recipeDTO.strMeasure20,
           recipeDTO.strSource,
           recipeDTO.strImageSource,
           recipeDTO.strCreativeCommonsConfirmed,
           recipeDTO.dateModified
       )

        return meal
    }

    override fun mapToRecipeDTO(domainModel: Meal): RecipeDTO {

        val reicpeDto: RecipeDTO = RecipeDTO(
            domainModel.idMeal,
            domainModel.strMeal,
            domainModel.strDrinkAlternate,
            domainModel.strCategory,
            domainModel.strArea,
            domainModel.strInstructions,
            domainModel.strMealThumb,
            domainModel.strTags,
            domainModel.strYoutube,
            domainModel.strIngredient1,
            domainModel.strIngredient2,
            domainModel.strIngredient3,
            domainModel.strIngredient4,
            domainModel.strIngredient5,
            domainModel.strIngredient6,
            domainModel.strIngredient7,
            domainModel.strIngredient8,
            domainModel.strIngredient9,
            domainModel.strIngredient10,
            domainModel.strIngredient11,
            domainModel.strIngredient12,
            domainModel.strIngredient13,
            domainModel.strIngredient14,
            domainModel.strIngredient15,
            domainModel.strIngredient16,
            domainModel.strIngredient17,
            domainModel.strIngredient18,
            domainModel.strIngredient19,
            domainModel.strIngredient20,
            domainModel.strMeasure1,
            domainModel.strMeasure2,
            domainModel.strMeasure3,
            domainModel.strMeasure4,
            domainModel.strMeasure5,
            domainModel.strMeasure6,
            domainModel.strMeasure7,
            domainModel.strMeasure8,
            domainModel.strMeasure9,
            domainModel.strMeasure10,
            domainModel.strMeasure11,
            domainModel.strMeasure12,
            domainModel.strMeasure13,
            domainModel.strMeasure14,
            domainModel.strMeasure15,
            domainModel.strMeasure16,
            domainModel.strMeasure17,
            domainModel.strMeasure18,
            domainModel.strMeasure19,
            domainModel.strMeasure20,
            domainModel.strSource,
            domainModel.strImageSource,
            domainModel.strCreativeCommonsConfirmed,
            domainModel.dateModified
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

 */