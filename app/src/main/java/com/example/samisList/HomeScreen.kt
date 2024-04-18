package com.example.littlelemon

import ImageCarousel
import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.data.dairy
import com.example.littlelemon.data.drinks
import com.example.littlelemon.data.fruits
import com.example.littlelemon.data.grills
import com.example.littlelemon.data.homeSpecialItems
import com.example.littlelemon.data.meats
import com.example.littlelemon.data.vegetables


/*
In the code you provided, the ModalNavigationDrawer is used as a container that wraps around the
Scaffold. This is a common pattern in Jetpack Compose for creating a UI with a navigation drawer.
 The drawer is designed to be a part of the overall screen layout, not just a component within the Scaffold.

Here's a breakdown of how this works:

ModalNavigationDrawer: It is the outermost container in this layout. It manages the state of the
navigation drawer (whether it's open or closed) and defines what content should be displayed in the drawer.

DrawerContent: This is the content that will be displayed inside the drawer when it is opened. In
your case, this is defined by the DrawerPanel composable function.

Scaffold: This is nested inside the ModalNavigationDrawer. The Scaffold is used to define the
main content area of the screen, along with any app bars, floating action buttons, etc.
* */
data class Category(
    val name: String,
    val icon: Int,
    val route: String // Added route property
)

val categories = listOf(
    Category(
        name = "Grills",
        icon = R.drawable.grills,
        route = "grills" // This should match a route in your NavHost
    ),
    Category(
        name = "Fruits",
        icon = R.drawable.fruits,
        route = "fruits" // This should match a route in your NavHost
    ),
    Category(
        name = "DairyProducts",
        icon = R.drawable.milk,
        route = "dairy"
    ),
    Category(
        name = "Vegetables",
        icon = R.drawable.vegetables,
        route = "vegetables" // This should match a route in your NavHost
    ),
    Category(
        name = "Drinks",
        icon = R.drawable.drinks,
        route = "drinks" // This should match a route in your NavHost
    ),
    Category(
        name = "Meats",
        icon = R.drawable.meats,
        route = "meats"
    )

    // Add other categories as needed
)


@Composable
fun CategoriesRow(navController: NavHostController, categories: List<Category>) {
    LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {
        items(categories) { category ->
            CategoryIcon(category, navController)
        }
    }
}

@Composable
fun CategoryIcon(category: Category, navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .clickable { navController.navigate(category.route) }
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            ),
            shape = CircleShape,

            modifier = Modifier
                .size(80.dp) // Size including the shadow
        ) {
            Box(
                contentAlignment = Alignment.Center, // Center the icon inside the Box
                modifier = Modifier
                    .fillMaxSize() // The Box occupies the full size of the Card
            ) {
                Icon(
                    painter = painterResource(id = category.icon),
                    contentDescription = category.name,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(79.dp) // The actual size of the icon
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = category.name,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}


//
//@Composable
//fun CategoryIcon(category: Category, navController: NavHostController) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally, // This will align the children (icon and text) to the center
//        modifier = Modifier
//            .padding(8.dp)
//            .clickable { navController.navigate(category.route) },
//    ) {
//        // If you want to decrease the size of the icons, adjust the size here
//        Icon(
//            painter = painterResource(id = category.icon),
//            contentDescription = category.name,tint = Color.Unspecified,
//                    modifier = Modifier.size(78.dp) // Set the size as needed
//
//        )
//        // Spacing between the icon and text, adjust as needed
//        Spacer(modifier = Modifier.height(1.dp))
//        Text(
//            text = category.name,
//            fontWeight = FontWeight.Bold, // Make the text bolder
//            textAlign = TextAlign.Center // Ensure the text is centered under the icon
//        )
//    }
//}
//


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition",
    "SuspiciousIndentation"
)
@Composable   // backup dont delete
fun HomeScreen(
    userName: String? = "",
    // navController: NavHostController? = null,
    navController: NavHostController,
    paddingValues: PaddingValues,

    ) {

    Box {
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            val searchBarItems = fruits + grills + dairy + vegetables + drinks + meats

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bannernew),
                        contentDescription = "Background",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.matchParentSize()
                    )
                    Column { // Column for vertical arrangement
                        Spacer(modifier = Modifier.height(105.dp)) // Space above search bar

                        SearchBar(
                            navController = navController,
                            listOfItems = searchBarItems,
                            placeholderText = "Search.."
                        )

                        Spacer(modifier = Modifier.height(27.dp)) // Space between search bar and categories

                        CategoriesRow(navController, categories)
                    }
                }
            }




            // just for you
            val justForYouItems = listOf(fruits, grills, dairy, vegetables, drinks, meats)
            item {
                if (navController != null) {
                    JustForYouHeader()
                    Spacer(modifier = Modifier.height(7.dp)) // Adjust the height as needed

                    homeSpecialItems(
                        navController, itemsLists = justForYouItems

                    )
                }
            }

            // Assuming ImageCarousel is a composable that shows images and can be placed in a LazyColumn item scope
            item {
                // Your specific content for HomeScreen
                Spacer(modifier = Modifier.height(26.dp)) // Adjust the height as needed

                Box(modifier = Modifier.background(Color.Transparent)) {
                    val imageList =
                        listOf(R.drawable.delivery,R.drawable.hungry, R.drawable.cg,R.drawable.fruits2,R.drawable.veg)


                    ImageCarousel(images = imageList)

                }
            }

            item {
                Spacer(modifier = Modifier.height(46.dp)) // Adjust the height as needed

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            //.padding(bottom = 16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.banner9),
                            contentDescription = "Background",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.matchParentSize()
                        )
                        Spacer(modifier = Modifier.height(120.dp)) // Adjust the height as needed
                        HelpButton(url = "https://sami-ibrahim-portfolio.vercel.app/")

                    }
                }
            }


    }
}
@Composable
fun HelpButton(url: String) {
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            try {
                context.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, "No browser found to open the link", Toast.LENGTH_LONG).show()
            }
        },
        modifier = Modifier
            .fillMaxWidth()
           .wrapContentWidth(Alignment.End)
            .width(246.dp)
            .height(86.dp) // Adjust the height to match your design

         .padding(horizontal = 11.dp, vertical = 15.dp),
        shape = RoundedCornerShape(30.dp), // Adjust the corner radius to match your design
        colors = ButtonDefaults.buttonColors(Color(0xFFFF3C3C)) // Set the button background color to red
    ) {
        Icon(
            painter = painterResource(id = R.drawable.owl), // Replace with your custom icon resource ID
            contentDescription = "Custom Icon",
            tint = Color.White
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(

            text =  "The Full Story!",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.weight(0.8f).align(Alignment.CenterVertically)
        )
    }
}
@Composable
fun JustForYouHeader() {
    // Use MaterialTheme to respect the app's overall theme
  //  val typography = MaterialTheme.typography

            Text(
                text = "Just for you!",

                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 27.sp,
                modifier = Modifier
                    .wrapContentSize(Alignment.Center).fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.Transparent, shape = RoundedCornerShape(4.dp))
            )

}






















//
//@Composable   // backup dont delete
//fun HomeScreen(
//    userName: String? = "",
//    // navController: NavHostController? = null,
//    navController: NavHostController,
//    paddingValues: PaddingValues,
//
//    ) {
//
//    Box {
//
//        Image(
//            painter = painterResource(id = R.drawable.banner2),
//            contentDescription = "Top Banner",
//            modifier = Modifier
//                .fillMaxWidth()
//            //   .height(500.dp) // Set the height to that of your banner
//            // .align(Alignment.TopStart)
//        )
//        LazyColumn(
//            modifier = Modifier.padding(paddingValues)
//        ) {
//            val allItemList = fruits + grills + dairy + vegetables + drinks + meats
//
//            item {
//                Spacer(modifier = Modifier.height(111.dp)) // Adjust the height as needed
//
//                SearchBar(
//                    navController = navController,
//                    listOfItems = allItemList,
//                    placeholderText = "Search.."
//                )
//
//            }
//
//
//
//
//            item {
//                Spacer(modifier = Modifier.height(17.dp)) // Adjust the height as needed
//                if (navController != null) {
//                    CategoriesRow(navController, categories)
//
//                }
//            }
//
//
//            // just for you
//            val listOfItemLists = listOf(fruits, grills, dairy, vegetables, drinks, meats)
//            item {
//                if (navController != null) {
//                    Spacer(modifier = Modifier.height(37.dp)) // Adjust the height as needed
//
//                    homeSpecialItems(
//                        navController, itemsLists = listOfItemLists
//
//                    )
//                }
//            }
//
//            // Assuming ImageCarousel is a composable that shows images and can be placed in a LazyColumn item scope
//            item {
//                // Your specific content for HomeScreen
//                Spacer(modifier = Modifier.height(26.dp)) // Adjust the height as needed
//
//                Box(modifier = Modifier.background(Color.Transparent)) {
//                    val imageList =
//                        listOf(R.drawable.web3, R.drawable.web2, R.drawable.web)
//
//
//                    ImageCarousel(images = imageList)
//
//                }
//            }
//
//        }
//
//    }
//}