package com.example.intojetpackcompose.UI

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intojetpackcompose.Repository.RecipeRepository
import com.example.intojetpackcompose.Repository.RecipeRepositoryImpl
import com.example.intojetpackcompose.network.RetrofitService.ApiService
import com.example.intojetpackcompose.network.mdoel.RecipeDTO
import com.example.intojetpackcompose.network.mdoel.RecipeDtoMapper
import com.example.intojetpackcompose.recipeSecreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainScreenViewModel(val recipeRepository: RecipeRepositoryImpl) : ViewModel() {

    var _mainScreenState = MutableStateFlow(MainSceenState())
    val mainScreenState: StateFlow<MainSceenState> = _mainScreenState.asStateFlow()


    init{
        getRecipes()
    }
    private fun getRecipes() {
        _mainScreenState.value.isLoading=true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val recipeList = recipeRepository.getRecipeWithId()
                _mainScreenState.value.onLunchRecipeData = recipeList
            } catch (e: Exception) {
                _mainScreenState.value.error = e.message.toString()
                Log.d("ApiCallException", "ApiCallError:{${e.message}}" )
            }
            finally {
                _mainScreenState.value.isLoading=false
            }
        }
    }
}