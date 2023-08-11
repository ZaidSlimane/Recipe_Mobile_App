package com.example.intojetpackcompose.ViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.example.intojetpackcompose.API.RetrofitClient
import com.example.intojetpackcompose.domain.model.Meal
import com.example.intojetpackcompose.network.mdoel.RecipeDTO
import com.example.intojetpackcompose.network.mdoel.RecipesRepo.repo
import kotlinx.coroutines.launch
import javax.inject.Inject

class FirstAccessViewModel @Inject constructor(
    private val reipesRepo : repo
):ViewModel() {

    private val _firstAccessModel = MutableStateFlow((emptyList<RecipeDTO>()))
    val state: StateFlow<List<RecipeDTO>> = _firstAccessModel


    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val apiCall = RetrofitClient.apiService

    init{
        getRecipes()
    }


    fun getRecipes() {
        viewModelScope.launch {

            val recipe = reipesRepo.getRecipes()
            _firstAccessModel.value = recipe
        }
            /*
            _isLoading.value = true

            try {
                val response = apiCall.getRandomRecipes()
                if (response.isSuccessful) {
                    _firstAccessModel.value = response.body() ?: emptyList()
                } else {
                    _error.value = "Error: ${response.code()}"
                }
            } catch (e: Exception) {
                _error.value = "Error: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }

        */

    }
}