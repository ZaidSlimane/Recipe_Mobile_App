package com.example.intojetpackcompose.Repository

import androidx.lifecycle.viewModelScope
import coil.map.Mapper
import com.example.intojetpackcompose.UI.Constants.TOKEN
import com.example.intojetpackcompose.UI.MainSceenState
import com.example.intojetpackcompose.domain.model.Meal
import com.example.intojetpackcompose.network.Response.RecipeSearchResponse
import com.example.intojetpackcompose.network.RetrofitService.ApiService
import com.example.intojetpackcompose.network.mdoel.RecipeDTO
import com.example.intojetpackcompose.network.mdoel.RecipeDtoMapper
import kotlinx.coroutines.launch
import kotlin.random.Random

class RecipeRepositoryImpl(val apiService : ApiService,
    val dtoMapper: RecipeDtoMapper) : RecipeRepository {

    lateinit var fetchedRecipeDtoList : ArrayList<RecipeDTO>
    override suspend fun getRecipeWithQuery(
        authorizationCode: String,
        page: String,
        query: String
    ): RecipeSearchResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipeWithId(): List<Meal> {
        var currentId = 0
        var previouId = 0
        try {
            for (recipeIdIterrator in 0..5) {
                currentId = getRandomRecipeId()
                if (!currentId.equals(previouId))
                    fetchRecipeDataRandomly(id = currentId)?.let {
                        fetchedRecipeDtoList.add(it)
                    }
                previouId = currentId
            }
        }
        catch (e:Exception){
        }
        return dtoMapper.fromDtoList(fetchedRecipeDtoList)
    }



    private suspend fun fetchRecipeDataRandomly(token: String = TOKEN,
                                                id: Int) : RecipeDTO? {
        val resultOfFetching : RecipeDTO? = null

            try {
                val resultOfFetching = apiService.getRecipeData(token, id)
            } catch (e: Exception) {

            }

        return resultOfFetching
    }

    private fun  getRandomRecipeId(): Int{
        return Random.nextInt(1,2000)
    }

}