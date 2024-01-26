import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.intojetpackcompose.BottomNavigationBar
import com.example.intojetpackcompose.R
import com.example.intojetpackcompose.recipeSecreen
import java.time.format.TextStyle



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    borderRadius: Dp,
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit
) {


    Box(
        modifier = modifier
            .background(backgroundColor, shape = RoundedCornerShape(borderRadius))

    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = label,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}


/* fun Modifier.customShadow(
    color: Color = Color.Black,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    blurRadius: Dp = 0.dp
): Modifier = this.then(
    drawBehind {
        drawIntoCanvas { canvas ->
            val shadowPaint = Paint().apply {
                setShadowLayer(
                    blurRadius.toPx(),
                    offsetX.toPx(),
                    offsetY.toPx(),
                    color.toArgb()
                )
            }
            canvas.nativeCanvas.drawRect(size.toRect(), shadowPaint)
        }
    }
)

*/


@Composable
/*  fun NavigationGraph(navController: NavController) {
      NavHost(
          navController as NavHostController,
          startDestination = "recipes"
      ) {
          composable(BottomNavigationBAr.recipes.route) { recipeSecreen() }
          composable(BottomNavigationBAr.favourite.route) { favouriteScreen() }
          composable(BottomNavigationBAr.shoplist.route) { shopListScreen() }
      }
  }

 */

@Preview
@OptIn(ExperimentalMaterial3Api::class)
fun BottomNavigationBarView() {

    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationView(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        // Set background color to avoid the white flashing when you switch between screens
    )

}






@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BottomNavigationView(
    navController: NavHostController
) {
    val items = listOf(
        BottomNavigationBar.recipes,
        BottomNavigationBar.shoplist,
        BottomNavigationBar.Pantry,
        BottomNavigationBar.Profile
    )
    BottomNavigation (
        backgroundColor = Color.White,
        contentColor = colorResource(id = R.color.purple_200),
        modifier = Modifier.padding(1.dp)
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    androidx.compose.material.Icon(
                        painterResource(id = screen.icon),
                        contentDescription = null
                    )
                },
                label = { Text(screen.title) },
                selectedContentColor = colorResource(id =  R.color.food_green),
                unselectedContentColor = colorResource(id =  R.color.gray),
                alwaysShowLabel = true,
                selected = currentRoute == screen.route,
                onClick = {
                    // This if check gives us a "singleTop" behavior where we do not create a
                    // second instance of the composable if we are already on that destination

                    navController.navigate(screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {

                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}
@Composable
private fun Navigation(
    navController: NavHostController
) {


    NavHost(navController, startDestination = BottomNavigationBar.recipes.route) {
        composable(BottomNavigationBar.recipes.route)
        {

            recipeSecreen()
        }

        /*composable(BottomNavigationBar.route) {
         favouriteScreen()
        }

         */

        /*  composable(BottomNavigationBar.shoplist.route) {
              shopListScreen()
          }

          composable(BottomNavigationBar.Pantry.route){
              pantryScreen()
          }
          composable(BottomNavigationBar.Profile.route){
              profileScreen()
          }

         */

    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return  navBackStackEntry?.destination?.route
}


/*@Composable
fun searchFilter (){
    val cardList = listOf("Card 1", "Card 2", "Card 3", "Card 4", "Card 5")

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 9.dp, horizontal = 16.dp)
    ){
        items(cardList) { card ->
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 25.dp
                ),
                modifier = Modifier
                    .width(0.dp)
                    .fillMaxHeight()
                    .padding(end = 32.dp)
            ) {


                Box(
                    modifier = Modifier
                        .fillMaxSize()
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.food),
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

                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 28.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            ),
                            textAlign = TextAlign.Start,
                            text = ("YOUR MOTHER'S FOOD HEISENBERG")
                        )
                    }
                }


            }


        }
    }
}*/

