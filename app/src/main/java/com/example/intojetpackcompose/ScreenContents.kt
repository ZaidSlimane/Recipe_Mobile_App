package com.example.intojetpackcompose

import android.annotation.SuppressLint
import android.text.BoringLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.intojetpackcompose.Repository.RecipeRepository
import com.example.intojetpackcompose.Repository.RecipeRepositoryImpl
import com.example.intojetpackcompose.UI.MainScreenViewModel
import com.example.intojetpackcompose.domain.model.Meal
import com.example.intojetpackcompose.ViewModel.FirstAccessViewModel
import com.example.intojetpackcompose.network.mdoel.RecipeDTO
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay

@SuppressLint("SuspiciousIndentation")
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun recipeSecreen(mainScreenViewModel: MainScreenViewModel = hiltViewModel()){

    val recipeUiState by mainScreenViewModel.mainScreenState.collectAsState()

    val color1 = Color(0xFFB5D5B6)
    val color2 = Color(0xDCF5F5F5)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            color1,
                            color2
                        )

                    )
                )
        )
        {

            OutlinedTextField(value = "", onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(16.dp)
                    .shadow(5.dp, RoundedCornerShape(30.dp))
                    .background(Color(0XF2F3F5), shape = RoundedCornerShape(30.dp)),
                placeholder = {
                    Text(
                        text = "Search here",
                        modifier = Modifier.alpha(12f),
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    cursorColor = Color.Black,
                    textColor = Color.Black,
                    focusedIndicatorColor = colorResource(id = R.color.food_green),
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(30.dp),
                leadingIcon = {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.alpha(12f)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Search, contentDescription = "Search icon",
                            tint = Color(0xFF5AA2B8)
                        )
                    }
                }
            )




            dishyAnimation()

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
                    modifier = Modifier.fillMaxWidth()

                ) {
                    items(recipeUiState.onLunchRecipeData) { item ->
                        horizontalScrollableCards(recipes = item, recipeUiState.isLoading)
                    }
                }
            }
        }




@Composable
fun horizontalScrollableCards(recipes: Meal, isDataLoaded : Boolean) {


            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 25.dp
                ),
                modifier = Modifier
                    .width(320.dp)
                    .height(550.dp)
                    .padding(end = 32.dp)
            ) {


                Box(
                    modifier = Modifier
                        .fillMaxSize()
                )

                {
                    Image(
                        painter = rememberAsyncImagePainter(recipes.featured_image),
                        contentDescription = "foodIMG",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background
                                (
                                color = Color.Black.copy(alpha = 0.4f)
                            )
                    )


                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row() {
                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.FavoriteBorder,
                                    contentDescription = "Favourite_food",
                                    tint = Color.White
                                )

                            }

                        }

                        Text(

                            style = TextStyle(
                                fontSize = 28.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            ),
                            textAlign = TextAlign.Start,
                            text = (recipes.title!!)
                        )
                    }
                }


            }


        }






/*

@Composable
fun searchFilter () {
    val cardList = listOf("Card 1", "Card 2", "Card 3", "Card 4", "Card 5")
    val filters = listOf<Filter>(
        Filter("Cook now"),
        Filter("Breakfast"),
        Filter("Low Price"),
        Filter("Algerian"),
        Filter("Enamlisian")
    )

    Row(
        modifier = Modifier
            .padding(top = 5.dp, bottom = 34.dp, start = 16.dp,end = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(corner = CornerSize(32)))
                .background(colorResource(id = R.color.food_green)),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = Icons.Outlined.Info, contentDescription = "filterLogo",
            tint = Color.White
            )

        }

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 9.dp, horizontal = 16.dp)
        ) {




            items(filters) { card ->
                Card(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 2.dp
                    ),
                    modifier = Modifier
                        .width(130.dp)
                        .height(80.dp)
                        .padding(end = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.food_green))



                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Text(text = card.name,
                            color = Color.White)


                    }
                }
            }
        }


    }
}


 */