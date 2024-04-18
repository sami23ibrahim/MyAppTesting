package com.example.littlelemon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.littlelemon.data.dairy
import com.example.littlelemon.data.dairyCategories
import com.example.littlelemon.data.drinkCategories
import com.example.littlelemon.data.drinks
import com.example.littlelemon.data.fruits
import com.example.littlelemon.data.fruitsCategories
import com.example.littlelemon.data.grilladesCategories
import com.example.littlelemon.data.grills
import com.example.littlelemon.data.meatCategories
import com.example.littlelemon.data.meats
import com.example.littlelemon.data.vegetableCategories
import com.example.littlelemon.data.vegetables

interface Destination {
    val route:String
    val icon: ImageVector
    val title : String
}
object LogIn: Destination {
    override val route = "LogIn"
    override val icon= Icons.Filled.Email
    override val title = "LogIn"
}
object Home: Destination {
    override val route = "Home"
    override val icon= Icons.Filled.Home
    override val title = "Home"
}
object MenuList: Destination {
    override val route = "MenuList"
    override val icon= Icons.Filled.Menu
    override val title = "MenuList"
}
object ItemDetails: Destination {
    override val route = "ItemDetails/{itemId}" // Updated route with argument placeholder
    override val icon = Icons.Filled.Menu
    override val title = "ItemDetails"
}
object ShopingList: Destination {
    override val route = "ShopingList" // Updated route with argument placeholder
    override val icon = Icons.Filled.AddShoppingCart
    override val title = "ShopingList"
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNavigation() {
    val navController = rememberNavController()
    val drawerState = remember { DrawerState(DrawerValue.Closed) }
    val scope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // this will be shown when we open the drawer
//            DrawerPanel(onCloseClick = {
//                scope.launch {
//                    drawerState.close()
//
//                }
//            })
        }
    ) {
       Scaffold(
//
//           topBar = { if (currentRoute != LogIn.route) {
//                TopAppBar(drawerState, scope)
//           }
//
//
//            },

           bottomBar = { if (currentRoute != LogIn.route) {
                           MyBottonNavigation(navController)
                          }
           }

        )
        { paddingValues ->
            NavHost(navController = navController, startDestination = Home.route) {

                composable("Home?NavHostName={username}",
                    arguments = listOf(
                        navArgument(name = "username") {
                            type = NavType.StringType
                            defaultValue = "user"
                        }
                    )
                ) { backStackEntry ->
                    HomeScreen( userName = backStackEntry.arguments?.getString("username")
                        , navController
                        , paddingValues)
                    //    ,sharedViewModel)
                }

                composable("MenuList?name={username}",
                    arguments = listOf(
                        navArgument(name = "username") {
                            type = NavType.StringType
                            defaultValue = "user"
                        }
                    )
                ) { backStackEntry ->
                    MenuList(userName = backStackEntry.arguments?.getString("username"), navController)
                }
                composable(ShopingList.route) {
                    LoginScreen(navController)
                }
                composable(LogIn.route) {
                    LoginScreen(navController)
                }
                composable("ItemDetails/{itemId}/{listName}") { backStackEntry ->
                    val itemId = backStackEntry.arguments?.getString("itemId")?.toIntOrNull()
                    val listName = backStackEntry.arguments?.getString("listName")

                    if (itemId != null && listName != null) {
                        itemDetails(itemId, listName)
                    } else {

                    }
                }

                composable("grills") { SectionScreen(navController, grills, grilladesCategories, "grills", "Grills") }
                composable("fruits") { SectionScreen(navController, fruits, fruitsCategories, "fruits", "Fruits") }
                composable("dairy") { SectionScreen(navController,dairy , dairyCategories, "milk", "Dairy Products") }
                composable("vegetables") { SectionScreen(navController, vegetables, vegetableCategories, "vegetables", "Vegetables") }
                composable("drinks") { SectionScreen(navController, drinks, drinkCategories, "drinks", "Drinks") }
                composable("meats") { SectionScreen(navController, meats, meatCategories, "meats", "Meats") }

            }
        }
    }
}
