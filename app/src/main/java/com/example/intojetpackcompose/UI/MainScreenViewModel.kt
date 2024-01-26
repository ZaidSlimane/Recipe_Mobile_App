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
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
public class MainScreenViewModel
@Inject constructor (private val recipeRepository: RecipeRepositoryImpl) : ViewModel() {

    var _mainScreenState = MutableStateFlow(MainSceenState())
    val mainScreenState: StateFlow<MainSceenState> = _mainScreenState.asStateFlow()


    init {
        CoroutineScope(Dispatchers.IO).launch {
            getRecipes()
        }
    }
    private suspend fun getRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val recipeList = recipeRepository.getRecipeWithId()
                _mainScreenState.value.onLunchRecipeData = recipeList
                _mainScreenState.value.isLoading=false
                Log.d("loading", "{${_mainScreenState.value.isLoading}}")
            } catch (e: Exception) {
                _mainScreenState.value.error = e.message.toString()
                Log.d("ApiCallException", "ApiCallError:{${e.message}}" )
            }


        }
    }
}