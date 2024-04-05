package com.example.littlelemon
//***********WORKS BEFORE ADDING THE SCROLLING TO THE SECTION AFTER CLICK ON ICON*************************
//

//
//@androidx.compose.Composable
//@Composable
//fun MenuCategory(category: String, imageResId: Int) {
//    Column(
//        modifier = Modifier.background(Color.White)
//            .padding(horizontal = 8.dp, vertical = 7.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Box(
//            modifier = Modifier
//                .size(49.dp)
//                .background(Color.White),
//            contentAlignment = Alignment.Center
//        ) {
//            Image(
//                painter = painterResource(id = imageResId),
//                contentDescription = "$category icon",
//                modifier = Modifier.size(111.dp)
//            )
//        }
//        Spacer(modifier = Modifier.height(9.dp))
//
//
//        Box(
//            modifier = Modifier
//                .background(Color(0xFFececec), RoundedCornerShape(24.dp))
//                .padding(horizontal = 12.dp, vertical = 0.dp) // Adjust the padding as needed
//        ){
//        Text(
//
//            text = category,
//            color = Color.Black,
//            fontSize = 16.sp,
//            modifier = Modifier.padding(top = 2.dp)
//                             //  .padding(horizontal = 26.dp, vertical = 4.dp)
//                               .background(Color.Transparent,shape = RoundedCornerShape(24.dp))
//
//        )}
//
//    }
//}
//
//@OptIn(ExperimentalFoundationApi::class)
//@androidx.compose.Composable
//@Composable
//fun MenuListScreen(navController: NavHostController) {
//
//    // Define the position where you want to insert the WeeklySpecialCard and horizontal scrollable list of dishes
//    val insertPosition = 3 // Adjust this based on your requirement
//
//    LazyColumn {
//        item {
//            FullWidthImage(
//                imageId = R.drawable.grillades,
//                imageHeight = 84.dp
//            )
//        }
//
//        // Manually create a horizontally scrollable row for categories
//        stickyHeader {
//            Row(
//                modifier = Modifier
//                    .horizontalScroll(rememberScrollState())
//                    .padding(bottom = 6.dp, top = 0.dp)
//            ) {
//
//                Categories.forEach { (category, imageResId) ->
//
//                    MenuCategory(category, imageResId)
//                }
//            }
//
//
//        }

//        // Divider after the categories
//        item {
//            Divider(
//                modifier = Modifier.padding(vertical = 8.dp),
//                color = Color.Gray,
//                thickness = 0.5.dp
//            )
//        }
//
//        // Items before the WeeklySpecialCard
//        items(dishes.take(insertPosition)) { dish ->
//            MenuDish(dish, onDishClick = {dishId ->
//                navController.navigate("dishDetails/$dishId")
//            })
//        }
//
//        // Insert the WeeklySpecialCard and the horizontal scrollable list of dishes
//        item {
//            Divider(
//                modifier = Modifier.padding(vertical = 8.dp),
//                color = Color.Gray,
//                thickness = 0.5.dp
//            )
//            WeeklySpecialCard()
//
//            // Horizontal scrollable list of dishes
//            LazyRow {
//                items(dishes) { dish ->
//                    MenuDish(dish, onDishClick = { dishId ->
//                        if (navController != null) {
//                            // navController.navigate("DishDetails/$dishId")
//                            navController.navigate("dishDetails/$dishId")
//
//                        }
//                    })
//                }
//            }
//
//            Divider(
//                modifier = Modifier.padding(vertical = 8.dp),
//                color = Color.Gray,
//                thickness = 0.5.dp
//            )
//        }
//
//        // Items after the horizontal scrollable list
//        items(dishes.drop(insertPosition)) { dish ->
//            MenuDish(dish, onDishClick = { dishId ->
//                if (navController != null) {
//                    navController.navigate("dishDetails/$dishId")
//                }
//            })
//        }
//    }
//}
////***********WORKS BEFORE ADDING THE SCROLLING TO THE SECTION AFTER CLICK ON ICON*************************
//************ MAINACTIVITY() ************************
//package com.example.littlelemon
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import com.example.littlelemon.ui.theme.com.example.littlelemon.ui.theme.MyNavigation
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            com.example.littlelemon.ui.theme.MyNavigation()
//        }
//    }
//}




//************ HomeScreen() ************************
//package com.example.littlelemon
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.DrawerValue
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.ModalNavigationDrawer
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.rememberBottomSheetScaffoldState
//import androidx.compose.material3.rememberDrawerState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.NavHostController
//import com.example.littlelemon.ui.theme.Add
//import kotlinx.coroutines.launch
//
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
///*
//In the code you provided, the ModalNavigationDrawer is used as a container that wraps around the
//Scaffold. This is a common pattern in Jetpack Compose for creating a UI with a navigation drawer.
// The drawer is designed to be a part of the overall screen layout, not just a component within the Scaffold.
//
//Here's a breakdown of how this works:
//
//ModalNavigationDrawer: It is the outermost container in this layout. It manages the state of the
//navigation drawer (whether it's open or closed) and defines what content should be displayed in the drawer.
//
//DrawerContent: This is the content that will be displayed inside the drawer when it is opened. In
//your case, this is defined by the DrawerPanel composable function.
//
//Scaffold: This is nested inside the ModalNavigationDrawer. The Scaffold is used to define the
//main content area of the screen, along with any app bars, floating action buttons, etc.
//* */
//@Composable
////Hierarchical Structure:
////BottomSheetScaffoldWithContent
////   mainContent (Lambda function)
////      ModalNavigationDrawer
////        Scaffold
////            Actual screen content (Column with various UI components)
//fun HomeScreen(navController: NavHostController? = null) {
//    val drawerState = rememberDrawerState(DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
//
//
//    BottomSheetScaffoldWithContent(
//        scaffoldState = bottomSheetScaffoldState,
//        mainContent =
//        //mainContent Lambda in BottomSheetScaffoldWithContent: This is where you define
//        // the main content of your screen, which will be displayed above the bottom sheet. The
//        // content here is what the user sees when the bottom sheet is not expanded.
//        {
//            ModalNavigationDrawer(
//                drawerState = drawerState, // starts with DrawerValue.Closed
//                drawerContent = { // this will be shown when we open the drawer
//                    DrawerPanel(onCloseClick = {
//                        scope.launch {
//                            drawerState.close()
//
//                        }
//                    })
//                }
//            )
//            {
//                Scaffold( // is what will be shown on the screen behind the drawer
//                    topBar = {
//                        TopAppBar(drawerState, scope)
//                    }
//                )
//
//
//                { paddingValues ->
//                    Column(
//                        modifier = Modifier
//                            .verticalScroll(rememberScrollState())
//                            .padding(paddingValues)
//                    )
//                    {
//
//                        UpperPanel(navController)
//                        WeeklySpecialCard()
//                        MenuDish("SHAWARMA")
//                        Add("SHAWARMA")
//                        MenuDish("GREEK SALAD ")
//                        Add("GREEK SALAD ")
//                        MenuDish("FALAFEL")
//                        MenuDish("MEOW")
//                        MenuDish("BURGER")
//
//                    }
//                }
//            }
//        }
//    )
//}
//
//
//
//
//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen()
//
//}




//************LoginScreen() ************************
//package com.example.littlelemon
//
//import android.widget.Toast
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import com.example.littlelemon.ui.theme.LittleLemonTheme
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LoginScreen(navController: NavHostController? = null) {
//    /*
//    Another approach is to make the navController parameter nullable
//    and provide a default value of null. In your actual app, you pass
//    the real NavHostController, while in the preview, you don't pass anything.
//     */
//
//    val context = LocalContext.current
//    var username by rememberSaveable( ) { mutableStateOf("") }
//    var password by rememberSaveable( ) { mutableStateOf("") }
//
//    Column( modifier = Modifier.fillMaxSize().background(Color.White),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally)
//    {
//        Image(
//            painter = painterResource(id = R.drawable.littlelemonlogo),
//            modifier=Modifier.padding(10.dp),
//            contentDescription = "Logo Image"
//
//        )
//        TextField(
//            modifier=Modifier.padding(6.dp),
//            shape = RoundedCornerShape(7.dp),
//            value = username,  // Bind the text field value to the username variable
//            onValueChange = { username = it },  // Update username variable when text changes
//            label = { Text("Username") } // Label for the TextField
//            // You can add modifiers for styling as needed
//        )
//        TextField(
//            modifier=Modifier.padding(6.dp),
//            shape = RoundedCornerShape(7.dp),
//            value = password,  // Bind the text field value to the password variable
//            onValueChange = { password = it },  // Update password variable when text changes
//            label = { Text("Password") }
//        )
//        Button(
//            onClick = {  if ((password =="sami")&&(username=="sami" )){
//                Toast.makeText(context,"Welcome to Little Lemon!", Toast.LENGTH_SHORT).show()
//                navController?.navigate("Home")
//                /*
//                Using Safe Call (?.)
//                Safe calls are a common way to deal with nullable types in Kotlin.
//                You use the ?. operator to safely call a method on a nullable object.
//                If the object is null, the method won't be called, and the expression evaluates to null.
//                 */
//
//
//
//            }else(Toast.makeText(context,"Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show()
//                    )
//            },
//            shape = RoundedCornerShape(7.dp),
//            colors = ButtonDefaults.buttonColors(
//                containerColor = Color(android.graphics.Color.parseColor("#495E57")), // Green background
//                contentColor = Color(android.graphics.Color.parseColor("#EDEFEE")) // Text color
//            ),
//            modifier = Modifier.padding(6.dp)
//        ) {
//            Text("Login")
//        }
//
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun  LoginScreenComponent() {
//    LittleLemonTheme {
//        LoginScreen()
//    }
//}






//************  UpperPanel()   ************************
//package com.example.littlelemon
//
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//
//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun UpperPanel(navController: NavHostController? = null) {
//    val context = LocalContext.current
//
//
//    Column (
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color(0XFF495E57)),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.Start
//    ){
//        Text(
//            text = "Little Lemon!",
//            fontSize = 32.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color(0xFFF4CE14),
//            modifier = Modifier.padding(start = 23.dp,top = 20.dp)
//        )
//        Text(
//            text = stringResource(R.string.chicago),
//            fontSize = 24.sp,
//            color = Color(0xFFFFFFFF),
//            modifier = Modifier.padding(start = 23.dp)
//        )
//        Row (horizontalArrangement = Arrangement.Start,modifier = Modifier
//            .fillMaxWidth()
//            .padding(20.dp))
//        {
//            Text(
//                text = stringResource(R.string.discriptionone),
//                fontSize = 21.sp,
//                color = Color(0xFFFFFFFF),
//                modifier = Modifier.width(200.dp)
//            )
//
//            Image(painter = painterResource(id = R.drawable.littlelemonlogo ),
//                contentDescription = "img",
//                Modifier
//                    .height(200.dp)
//                    // .width(100.dp)
//                    .clip(RoundedCornerShape(14.dp)))
//
//        }
//        Button(
//            onClick = {
//                navController?.navigate("MenuList")
//                //   Toast.makeText(context,"Order successful!", Toast.LENGTH_SHORT).show()
//            }
//            ,modifier = Modifier
//                .padding(horizontal = 20.dp)
//                .padding(bottom = 20.dp)
//            ,shape= RoundedCornerShape(20.dp)
//            ,colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFF4CE14))
//
//        )
//        {
//            Text(
//                text = "Full Menu..",
//                color = Color.Black,
//                fontSize = 22.sp,
//            )
//        }
//
//    }
//}
//
//
//
//@Preview(showBackground = true)
//@Composable
//fun MainComponentPreview() {
//    UpperPanel()
//}





//************  LowerPanel()   ************************
//
//package com.example.littlelemon
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.material3.Card
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//@Composable
//fun WeeklySpecialCard(){
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//    ) {
//        Text(
//            text = "Weekly Special",
//            fontSize = 26.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier
//                .padding(8.dp)
//        )
//    }
//}
////********************************************************
//@Composable
//fun MenuDish(foodName:String) {
//    Card(
//        modifier = Modifier.padding(6.dp) // Adds padding around the Card
//    )  {
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        ) {
//            Column {
//                Text(
//                    text = "$foodName",
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = "The famous greek salad of " +
//                            "crispy lettuce, peppers, olives, " +
//                            "our Chicago ...",
//                    color = Color.Gray,
//                    modifier = Modifier
//                        .padding(top = 5.dp, bottom = 5.dp)
//                        .fillMaxWidth(.75f)
//                )
//                Text(
//                    text = "$12.99",
//                    color = Color.Gray,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//            Image(
//                painter = painterResource(
//                    id = R.drawable.greek),
//                contentDescription = "img",
//
//                )
//        }
//    }
//}
////********************************************************
//
//@Preview(showBackground = true)
//@Composable
//fun WeeklySpecialCardPreview() {
//    WeeklySpecialCard()
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun   MenuDishPreview() {
//    MenuDish("SHAWARMA")
//}





//************ Add  ()   ************************
//
//package com.example.littlelemon.ui.theme
//
//import android.widget.Toast
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun Add(foodName :String ){
//    var count by rememberSaveable( ) { mutableStateOf(0) }
//    ItemOrder(foodName,count,{count++},{ if (count > 0) count-- })
//}
//
//
//@Composable
//fun ItemOrder(foodName: String ,count: Int, onIncrement:()-> Unit, onDecrement:()->Unit) {
//    val context = LocalContext.current
//    Column(
//        modifier = Modifier
//            .fillMaxWidth(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Card() {
//            Column(modifier = Modifier.padding(20.dp)) {
//                Text(
//                    text = "$foodName",
//                    fontWeight = FontWeight.W700,
//                    fontSize = 30.sp
//                )
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    horizontalArrangement = Arrangement.Center,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    TextButton(onClick = { if (count > 0) onDecrement() }) {
//                        Text("-", fontSize = 32.sp)
//                    }
//                    Spacer(modifier = Modifier.width(26.dp))
//                    Text(
//                        text = count.toString(),
//                        modifier = Modifier.size(42.dp),
//                        fontSize = 32.sp
//                    )
//                    Spacer(modifier = Modifier.width(16.dp))
//                    TextButton(onClick = {onIncrement()}) {
//                        Text("+", fontSize = 32.sp)
//                    }
//                }
//                Button(onClick= {
//                    if (count > 0){
//                        Toast.makeText(context,"Items Added Successfully!", Toast.LENGTH_SHORT).show()
//                    }}
//                    , Modifier.fillMaxWidth()) {
//                    Text(text = "Add")
//                }
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun AddPreview() {
//    LittleLemonTheme {
//        Add("SHAWARMA")
//    }
//}





///************* Drawer()   *********************************

//package com.example.littlelemon
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ExitToApp
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalConfiguration
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun DrawerPanel(onCloseClick: () -> Unit){//This lambda is a placeholder for some action that should
//// occur when the IconButton is clicked. It is not defined within DrawerPanel itself, but rather it
//// should be provided by the composable that calls DrawerPanel.
//
//    val screenWidth = LocalConfiguration.current.screenWidthDp.dp//Retrieves the current screen width.
//    val drawerWidth = (screenWidth.value * 0.8).dp // Convert to Float, multiply, and convert back to Dp
//
//    Column(
//        modifier = Modifier
//            .width(drawerWidth)
//            .fillMaxHeight()  // This line will make the drawer take the full height
//            .background(Color.White)
//    ) {
//        LazyColumn {
//            items(10) { index ->
//                Text(
//                    text = "Item #$index",
//                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
//                )
//            }
//        }
//        IconButton(onClick = { onCloseClick() }) {
//            Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Close Icon")
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DrawerPanelPreview() {
//    //DrawerPanel()
//}




///************* TopAppBar()   ****************

//
//package com.example.littlelemon
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Menu
//import androidx.compose.material.icons.filled.ShoppingCart
//import androidx.compose.material3.DrawerState
//import androidx.compose.material3.DrawerValue
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.rememberDrawerState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.launch
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TopAppBar(drawerState: DrawerState, scope: CoroutineScope){
//    Row(horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier.fillMaxWidth()
//            .background(Color.White)
//        ,
//        verticalAlignment = Alignment.CenterVertically
//    )
//    {
//        IconButton(onClick = {
//            scope.launch {
//                if (drawerState.isOpen) {
//                    drawerState.close()
//                } else {
//                    drawerState.open()
//                }
//            }
//        }) {Icon(imageVector= Icons.Default.Menu,
//            contentDescription = " Menu Icon ",
//            modifier= Modifier.size(24.dp))
//
//        }
//
//
//        Image(painter = painterResource(id = R.drawable.ll) ,
//            contentDescription = "Logo",
//            modifier= Modifier.fillMaxWidth(0.5F)
//                .padding(horizontal = 20.dp)
//                .height(28.dp)
//        )
//        IconButton(onClick = { /*TODO*/
//        }) {Icon(imageVector= Icons.Default.ShoppingCart,
//            contentDescription = " Cart ",
//            modifier= Modifier.size(24.dp))
//           modifier= Modifier.size(24.dp))
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun TopAppBarPreview() {
//    val mockDrawerState = rememberDrawerState(DrawerValue.Closed)
//    val mockScope = rememberCoroutineScope()
//
//    TopAppBar(drawerState = mockDrawerState, scope = mockScope)
//}






//**************** BottomSheetContent()  ******************************************
//
//package com.example.littlelemon
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material3.BottomSheetScaffold
//import androidx.compose.material3.BottomSheetScaffoldState
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun BottomSheetContent() {
//    Row(horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier.background(color = Color.LightGray)
//            .padding(10.dp).fillMaxWidth()
//    )
//    {
//
//        Image(
//            painter = painterResource(id = R.drawable.greek),
//            contentDescription = "Orders",
//            modifier = Modifier.size(90.dp)
//        )
//        Spacer(modifier = Modifier.size(6.dp))
//
//        Image(
//            painter = painterResource(id = R.drawable.greek),
//            contentDescription = "Account",
//            modifier = Modifier.size(90.dp)
//        )
//        Spacer(modifier = Modifier.size(6.dp))
//
//        Image(
//            painter = painterResource(id = R.drawable.greek),
//            contentDescription = "Basket",
//            modifier = Modifier.size(90.dp)
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun  BottomSheetContentPreview() {
//    BottomSheetContent()
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun BottomSheetScaffoldWithContent(
//    scaffoldState: BottomSheetScaffoldState,
//    mainContent: @Composable (Modifier) -> Unit
//) {
//    BottomSheetScaffold(
//        scaffoldState = scaffoldState,
//        sheetContent = { BottomSheetContent() }, // Use the BottomSheetContent composable here
//        content = { paddingValues ->
//            mainContent(Modifier.padding(paddingValues))
//        }
//    )
//}






//*******************  Menu()   ***********************************
//package com.example.littlelemon
//
//import android.content.res.Configuration
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalConfiguration
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import com.example.littlelemon.ui.theme.Pink80
//import com.example.littlelemon.ui.theme.Purple80
//import com.example.littlelemon.ui.theme.PurpleGrey80
//
//@Composable
//fun MenuList(navController: NavHostController?=null) {
//    val paddingValues = PaddingValues(all = 16.dp)
//    Surface(modifier = Modifier.padding(paddingValues)) {
//        val menuPadding = 18.dp
//        val configuration = LocalConfiguration.current
//        when (configuration.orientation) {
//            Configuration.ORIENTATION_LANDSCAPE -> {
//                Column {
//                    Row(modifier = Modifier.weight(0.50f)) {
//                        Button(
//                            onClick = {
//                                navController?.navigate("Home")
//                                //  Toast.makeText(context,"Order successful!", Toast.LENGTH_SHORT).show()
//                            }
//                            ,modifier = Modifier
//                                .padding(horizontal = 20.dp)
//                                .padding(bottom = 20.dp)
//                            ,shape= RoundedCornerShape(20.dp)
//                            ,colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFF4CE14))
//
//                        )
//                        {
//                            Text(
//                                text = "TO HOME SCREEN",
//                                color = Color.Black,
//                                fontSize = 22.sp,
//                            )
//                        }
//                        Text(
//                            "Appetizers",
//                            fontSize = 22.sp,
//                            modifier = Modifier
//                                .weight(0.25f)
//                                .fillMaxHeight()
//                                .background(Purple80)
//                                .padding(menuPadding)
//                        )
//                        Text(
//                            "Salads",
//                            fontSize = 22.sp,
//                            modifier = Modifier
//                                .weight(0.25f)
//                                .fillMaxHeight()
//                                .padding(menuPadding)
//                        )
//                    }
//                    Row(modifier = Modifier.weight(0.50f)) {
//
//
//                        Text(
//                            "Drinks",
//                            fontSize = 22.sp,
//                            modifier = Modifier
//                                .weight(0.25f)
//                                .fillMaxHeight()
//                                .background(Pink80)
//                                .padding(menuPadding)
//                        )
//                        Text(
//                            "Mains",
//                            fontSize = 22.sp,
//                            modifier = Modifier
//                                .weight(0.25f)
//                                .fillMaxHeight()
//                                .background(PurpleGrey80)
//                                .padding(menuPadding)
//                        )
//                    }
//                }
//            }
//            else -> {
//                Column {
//
//                    Button(
//                        onClick = {
//                            navController?.navigate("Home")
//                            //  Toast.makeText(context,"Order successful!", Toast.LENGTH_SHORT).show()
//                        }
//                        ,modifier = Modifier
//                            .padding(horizontal = 20.dp)
//                            .padding(bottom = 20.dp)
//                        ,shape= RoundedCornerShape(20.dp)
//                        ,colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFF4CE14))
//
//                    )
//                    {
//                        Text(
//                            text = "TO HOME SCREEN",
//                            color = Color.Black,
//                            fontSize = 22.sp,
//                        )
//                    }
//
//
//
//                    Text(
//                        "Appetizers",
//                        fontSize = 22.sp,
//                        modifier = Modifier
//                            .weight(0.25f)
//                            .background(Purple80)
//                            .padding(menuPadding)
//                            .fillMaxWidth()
//                    )
//                    Text(
//                        "Salads",
//                        fontSize = 22.sp,
//                        modifier = Modifier
//                            .weight(0.25f)
//                            .padding(menuPadding)
//                            .fillMaxWidth()
//                    )
//                    Text(
//                        "Drinks",
//                        fontSize = 22.sp,
//                        modifier = Modifier
//                            .weight(0.25f)
//                            .background(Pink80)
//                            .padding(menuPadding)
//                            .fillMaxWidth()
//                    )
//                    Text(
//                        "Mains",
//                        fontSize = 22.sp,
//                        modifier = Modifier
//                            .weight(0.25f)
//                            .background(PurpleGrey80)
//                            .padding(menuPadding)
//                            .fillMaxWidth()
//                    )
//                }
//            }
//        }
//    }
//}
//
//
//@Composable
//@Preview(showBackground = true)
//fun MenuContentPreview() {
//    MenuList()
//}
//






//************** Destination()   *******************************************
//package com.example.littlelemon.ui.theme
//
//import androidx.compose.Composable
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.littlelemon.HomeScreen
//import com.example.littlelemon.LoginScreen
//import com.example.littlelemon.MenuList
//
//interface Destination {
//    val route:String
//}
//object LogIn:Destination{
//    override val route = "LogIn"
//}
//object Home:Destination{
//    override val route = "Home"
//}
//object MenuList:Destination{
//    override val route = "MenuList"
//}
//
///*
//Objects: Home and MenuList are singleton objects in Kotlin, implementing
//the Destination interface.
// */
//
//@androidx.compose.runtime.Composable
//@Composable
//fun com.example.littlelemon.ui.theme.MyNavigation(){
//    val navController = rememberNavController()
////rememberNavController(): Creates and remembers a NavController, which manages app navigation within a NavHost.
//    NavHost(navController = navController, startDestination = LogIn.route){
////The NavHost is a composable that hosts the navigation graph for the app.
////navController: The NavController instance to manage navigation.
////startDestination: Specifies the starting destination for the NavHost. Here, it's set to Home.route,
////so the Home screen is the first screen shown.
//
//        /*
//        Navigation Graph:
//Defined within the NavHost block.
//composable(Home.route) { HomeScreen(navController) }: Defines a composable associated with the Home route.
//When navigating to this route, the HomeScreen is displayed.
//         */
//        composable(Home.route){
//            HomeScreen(navController)
//        }
//        composable(MenuList.route){
//            MenuList(navController)
//        }
//        composable(LogIn.route){
//            LoginScreen(navController)
//        }
//    }
//}

