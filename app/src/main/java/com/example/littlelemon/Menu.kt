package com.example.littlelemon

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun MenuList(userName : String?= "",navController: NavHostController?=null) {
  //  ShoppingCartDisplay(ShopingListManager.ShopingListItems)
  //  ShoppingCartDisplay(ShopingListManager.ShopingListItems, viewModel: ShoppingCartViewModel)

    ShoppingCartDisplay(ShopingListManager.ShopingListItems)

//    val paddingValues = PaddingValues(all = 16.dp)
//    Surface(modifier = Modifier.padding(paddingValues)) {
//        val menuPadding = 18.dp
//        val configuration = LocalConfiguration.current
//        when (configuration.orientation) {
//            Configuration.ORIENTATION_LANDSCAPE -> {
//                Column {
//                    Row(modifier = Modifier.weight(0.50f)) {
//                        Text("Hello $userName")
////                        Button(
////                            onClick = {
////                               // navController?.navigate("Home")
////                                navController?.navigate("Home?name=$userName")
////                                //  Toast.makeText(context,"Order successful!", Toast.LENGTH_SHORT).show()
////                            }
////                            ,modifier = Modifier
////                                .padding(horizontal = 20.dp)
////                                .padding(bottom = 20.dp)
////                            ,shape= RoundedCornerShape(20.dp)
////                            ,colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFF4CE14))
////
////                        )
////                        {
////                            Text(
////
////                                text = "TO HOME SCREEN",
////                                color = Color.Black,
////                                fontSize = 22.sp,
////                            )
////                        }
//                        Text(
//                            "Appetizers",
//                            fontSize = 22.sp,
//                            modifier = Modifier
//                                .weight(0.25f)
//                                .fillMaxHeight()
//                                .background(LittleLemonColor.Purple80)
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
//                                .background(LittleLemonColor.Pink80)
//                                .padding(menuPadding)
//                        )
//                        Text(
//                            "Mains",
//                            fontSize = 22.sp,
//                            modifier = Modifier
//                                .weight(0.25f)
//                                .fillMaxHeight()
//                                .background(LittleLemonColor.PurpleGrey80)
//                                .padding(menuPadding)
//                        )
//                    }
//                }
//            }
//            else -> {
//                Column {
//                    Text("Hello $userName")
////                    Button(
////                        onClick = {
////                            navController?.navigate("Home?name=$userName")
////                            //  Toast.makeText(context,"Order successful!", Toast.LENGTH_SHORT).show()
////                        }
////                        ,modifier = Modifier
////                            .padding(horizontal = 20.dp)
////                            .padding(bottom = 20.dp)
////                        ,shape= RoundedCornerShape(20.dp)
////                        ,colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFF4CE14))
////
////                    )
////                    {
////                        Text(
////                            text = "TO HOME SCREEN",
////                            color = Color.Black,
////                            fontSize = 22.sp,
////                        )
////                    }
//
//                    Text(
//                        "Appetizers",
//                        fontSize = 22.sp,
//                        modifier = Modifier
//                            .weight(0.25f)
//                            .background(LittleLemonColor.Purple80)
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
//                            .background(LittleLemonColor.Pink80)
//                            .padding(menuPadding)
//                            .fillMaxWidth()
//                    )
//                    Text(
//                        "Mains",
//                        fontSize = 22.sp,
//                        modifier = Modifier
//                            .weight(0.25f)
//                            .background(LittleLemonColor.PurpleGrey80)
//                            .padding(menuPadding)
//                            .fillMaxWidth()
//                    )
//                }
//            }
//        }
//    }
}


@Composable
@Preview(showBackground = true)
fun MenuContentPreview() {
    MenuList()
}
