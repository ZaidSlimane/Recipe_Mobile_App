package com.example.intojetpackcompose.Repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.viewModelScope
import coil.map.Mapper
import com.example.intojetpackcompose.BottomNavigationBar
import com.example.intojetpackcompose.UI.Constants.TOKEN
import com.example.intojetpackcompose.UI.MainSceenState
import com.example.intojetpackcompose.domain.model.Meal
import com.example.intojetpackcompose.network.Response.RecipeSearchResponse
import com.example.intojetpackcompose.network.RetrofitService.ApiService
import com.example.intojetpackcompose.network.RetrofitService.RecipeService
import com.example.intojetpackcompose.network.mdoel.RecipeDTO
import com.example.intojetpackcompose.network.mdoel.RecipeDtoMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject
import kotlin.random.Random

class RecipeRepositoryImpl
@Inject constructor(
    private val apiService : RecipeService,
    private val dtoMapper: RecipeDtoMapper) : RecipeRepository {
    val fetchedRecipeDtoList : ArrayList<Meal>

    init {
        fetchedRecipeDtoList = ArrayList<Meal>()
    }


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
                Log.d("Debug", "executed?1")
                currentId = getRandomRecipeId()
                if (!currentId.equals(previouId)) {
                    Log.d("Debug", "executed?2")

                    fetchRecipeDataRandomly(id=currentId)?.let {
                        fetchedRecipeDtoList.add(it)
                    }
                }
                previouId = currentId
            }
        }
        catch (e:Exception){
            Log.d("exception", "check1:${e.message}")
        }
        return fetchedRecipeDtoList
    }



    @SuppressLint("SuspiciousIndentation")
    private suspend fun fetchRecipeDataRandomly(token: String = TOKEN,
                                                id: Int) : Meal {
        lateinit var resultOfFetching : RecipeDTO
            try {
                Log.d("Debug", "executed?3")
                resultOfFetching = apiService.get(token,id=id)
                Log.d("try", "${resultOfFetching.title}")
            } catch (e: Exception) {
                Log.d("exception", "check2: ${e.message}")

            }
        return dtoMapper.mapToDomainModel(resultOfFetching)
    }

    private fun  getRandomRecipeId(): Int{
        return Random.nextInt(1,2000)
    }

}