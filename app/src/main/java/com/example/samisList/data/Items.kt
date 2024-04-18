package com.example.littlelemon.data

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.ShopingListManager
import kotlin.math.max


fun getItem(id: Int, listName: String): Item? {
    val listsMap = mapOf(
        "grills" to grills,
        "fruits" to fruits  ,
        "dairy" to dairy,
        "vegetables" to vegetables  ,
        "drinks" to drinks,
        "meats" to meats
    )

    val itemsList = listsMap[listName]
    return itemsList?.firstOrNull { it.id == id }
}
/* firstOrNull is a standard library function in Kotlin that iterates over the
elements of a collection and returns the first element that matches the given
condition. If no element matches, it returns null.
 */
data class Item(
    val type:String,
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val image: Int,
    val category: String,
    val special: Boolean,
    val aisle :Int

)
fun applyDiscount(priceString: Double, discount: Int): String {
    return try {
        // Convert the price string to a double, filtering out non-digit and non-decimal point characters
        val priceDouble = priceString.toDouble()

        // Apply the discount. Ensure the result is not negative.
        val discountedPrice = max(0.0, priceDouble - discount)

        // Format the discounted price as a string with two decimal places
        String.format("%.2f", discountedPrice)
    } catch (e: NumberFormatException) {
        // Handle the error appropriately
        "Invalid Price"
    }
}




//************************

//@Composable
//fun MenuItem(
//    item: Item,
//    onDishClick: (Int) -> Unit
//) {
//    val itemCount: Int by remember { derivedStateOf { ShopingListManager.ShopingListItems[item.id]?.second ?: 0 } }
//
//    ElevatedCard(
//        elevation = cardElevation(
//            defaultElevation = 6.dp
//        ),
//        modifier = Modifier
//            .padding(13.dp)
//            .clickable { onDishClick(item.id) }
//            .fillMaxWidth() // Make sure the card fills the width of the screen
//            .height(170.dp), // Set a fixed height for the card
//        shape = RoundedCornerShape(15.dp), // Rounded corners for the card
//    ) {
//        Row(
//            modifier = Modifier
//                .background(Color.White)
//                .padding(8.dp)
//        ) {
//            Image(
//                painter = painterResource(id = item.image),
//                contentDescription = "Dish image",
//                modifier = Modifier
//                  //  .size(124.dp)
//                    .height(150.dp)
//                     .width(160.dp)
//                    .clip(RoundedCornerShape(14.dp))
//            )
//
//            Spacer(modifier = Modifier.width(8.dp))
//
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .align(Alignment.CenterVertically)
//            ) {
//                Text(
//                    text = item.name,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold
//                )
//
//                Spacer(modifier = Modifier.height(4.dp))
//
//                Text(
//                    text = item.description,
//                    color = Color.Gray,
//                  //  style = MaterialTheme.typography.body2
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//                Text(
//                    text = "Price: ${item.price}",
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.SemiBold
//                )
//            }
//
//            if (itemCount == 0) {
//                IconButton(
//                    onClick = { ShopingListManager.addItem(item) },
//                    modifier = Modifier
//                        .size(48.dp)
//                        .align(Alignment.Bottom)
//                ) {
//                    Icon(Icons.Default.Add, contentDescription = "Add")
//                }
//            } else {
//                CounterDisplay(
//                    x = 10, y = 100,
//                    itemCount = itemCount,
//                    updateItemCount = { newCount ->
//                        if (newCount > itemCount) {
//                            ShopingListManager.addItem(item)
//                        } else {
//                            ShopingListManager.removeItem(item)
//                        }
//                    },
//                    modifier = Modifier.align(Alignment.Bottom)
//                )
//            }
//        }
//    }
//}
//****************
@Composable
fun MenuItem(
    item: Item,
    onDishClick: (Int) -> Unit,
    backgroundColor: Color = Color(0xFFFFFFFF)
) {
    val itemCount: Int by remember { derivedStateOf { ShopingListManager.ShopingListItems[item.id]?.second ?: 0 } }

    ElevatedCard(
        elevation = cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
           // .padding(12.dp)
            .padding(start=22.dp,end=22.dp,top=22.dp)
            .clickable { onDishClick(item.id) }
    ) {
        Box(
            modifier = Modifier
                .background(backgroundColor)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = item.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        if (item.special) {
                            Spacer(modifier = Modifier.width(8.dp)) // Space between the name and the special tag
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp))
                                    .background(Color.Red)
                                    .padding(vertical = 8.dp, horizontal = 8.dp)
                            ) {
                                Text(
                                    text = "SPECIAL",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    Text(
                        text = item.description,
                        color = Color.Gray,
                        fontSize = 15.sp,

                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 5.dp)
                    )

                    // Conditional display of price based on whether dish is special
                    if (item.special) {

                        val displayedPrice = if (item.special) {
                            applyDiscount(item.price, 2) // Assuming the discount is $2
                        } else {
                            item.price.toDouble() // No discount
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = if (item.special) "Original Price: $${item.price}" else "Price: $${item.price}",
                                fontSize = 15.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.SemiBold,
                                textDecoration = TextDecoration.LineThrough
                            )

                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "$" +displayedPrice.toString(),
                                fontSize = 15.sp,
                                color = Color.Red,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    } else {
                        // Display the normal price when not special
                        Text(
                            text = if (item.special) "Original Price: $${item.price}" else "Price: $${item.price}",

                            //  text = "$" + String.format("%.2f", item.price.toDouble()),
                            fontSize = 15.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                // New: Plus button overlaying the image
                Box(
                    modifier = Modifier
                        .size(120.dp), // Match the size of the parent Box
                    contentAlignment = Alignment.BottomEnd
                ) {

                    Image(
                        painter = painterResource(id = item.image),
                        contentDescription = "Dish image",
                        modifier = Modifier
                            .size(120.dp)
                            .clip(RoundedCornerShape(14.dp))
                    )
                    // Only show the button if itemCount is 0
                    if (itemCount == 0) {
                        IconButton(
                            onClick = {
                                ShopingListManager.addItem(item) // This updates the cart, which will trigger recomposition
                            },
                            modifier = Modifier
                                .size(41.dp) .offset(y = (-5).dp,x = (-5).dp)
                                .background(Color.White, shape = CircleShape) // Circle background for plus icon
                                .padding(8.dp)
                        ) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = "Add to cart"
                            )
                        }
                    } else {
                        // New: Counter display that shows number of items added
                        CounterDisplay(-5, -5, itemCount = itemCount, updateItemCount = { newCount ->
                            if (newCount > itemCount) {
                                ShopingListManager.addItem(item)
                            } else {
                                ShopingListManager.removeItem(item)
                            }
                        })
                    }
                }
            }
        }
    }
}
@Composable
fun SpecialMenuItem(
    item: Item,
    onDishClick: (Int) -> Unit
) {
    val itemCount: Int by remember {
        derivedStateOf { ShopingListManager.ShopingListItems[item.id]?.second ?: 0
        }
    }

    ElevatedCard(
        elevation = cardElevation(
            defaultElevation = 0.dp
        ),
        modifier = Modifier

            .background(Color.Transparent)
            .width(190.dp)
             .height(245.dp)
           // .size(240.dp)
            .clip(RoundedCornerShape(14.dp))
            .padding(
                top = 8.dp,    // Adjust this value as needed for space above the card
                bottom = 8.dp, // Adjust this value as needed for space below the card
                start = 5.dp,  // Adjust this value as needed for space to the start of the card
                end = 8.dp     // Adjust this value as needed for space to the end of the card
            )

            .clickable { onDishClick(item.id) },
        shape = RoundedCornerShape(11.dp),
        // Set the elevation to 0 to remove any shadow

    ) {
        Column(modifier = Modifier.background(Color.Transparent)) {
            Box(
                modifier = Modifier
                    .height(185.dp)
                    .fillMaxWidth().background(Color.Transparent)
            ) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = "Item Image",
                    modifier = Modifier
                        .fillMaxSize().background(Color.Transparent)
                        //   .clip(RoundedCornerShape(45.dp))
                        .size(170.dp)
                        .clip(RoundedCornerShape(24.dp))
                )

                // Use a Box to ensure the counter stays in place
                Box(
                    modifier = Modifier
                        .matchParentSize().background(Color.Transparent)
                ) {
                    // The counter or button will always be aligned to the bottom end
                    if (itemCount > 0) {
                        CounterDisplay(
                            x = 45, y = 135,
                            itemCount = itemCount,
                            updateItemCount = { newCount: Int ->
                                if (newCount > itemCount) {
                                    ShopingListManager.addItem(item)
                                } else {
                                    ShopingListManager.removeItem(item)
                                }
                                // Do not manually set itemCount here; it's automatically updated
                            },
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(bottom = 8.dp, end = 8.dp)
                                //  .size(48.dp)
                                .background(Color.Red, shape = CircleShape)
                        )
                    }  else {
                        IconButton(
                            onClick = {
                                ShopingListManager.addItem(item)
                                // Do not manually set itemCount here; it's automatically updated
                            },
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(bottom = 12.dp, end = 16.dp)
                                .size(40.dp)
                                .background(color =Color(0xFFF1F3F3), shape = CircleShape)

                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    }
                }
                // Weekly Special Tag
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 18.dp, end = 12.dp)
                ) {
                    Text(
                        text = "Special Offer",
                        color = Color.White,
                        modifier = Modifier
                            .background(Color.Red, shape = RoundedCornerShape(6.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }
            // Dish Details
            Column(
                modifier = Modifier
                    .fillMaxWidth() .background(Color.Transparent)
                    .padding(2.dp)
                ,horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .background(Color.Transparent),
                        text = "$" +item.price.toString(),
                        fontSize = 15.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold,
                        textDecoration = TextDecoration.LineThrough
                    )
                    Spacer(modifier = Modifier.width(13.dp))

                    Text(
                        text ="$" + applyDiscount(item.price, 2),
                        fontSize = 15.sp,
                        color = Color.Red,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}
// New: Composable to display and adjust the item count
@Composable
fun CounterDisplay(
    y: Int,
    x: Int,
    itemCount: Int,
    modifier: Modifier = Modifier,
    updateItemCount: (Int) -> Unit,
    backgroundColor: Color = Color.White, // Default background color is White
    fontSize: TextUnit = 20.sp // Default font size is 20.sp
) {
    Row(
        modifier = Modifier
            .offset(y = y.dp, x = x.dp)
            .background(color =Color(0xFFF1F3F3), shape = CircleShape) // Use backgroundColor parameter
            .padding(start = 6.dp, top = 0.dp, end = 8.dp, bottom = 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { if (itemCount > 0) updateItemCount(itemCount - 1) },
            modifier = Modifier.size(24.dp)
        ) {
            Icon(

                imageVector = Icons.Default.Remove,
                contentDescription = "Decrease count",
                modifier = Modifier.size(30.dp)
            )
        }
        Text(
            text = itemCount.toString(),
            modifier = Modifier.padding(start = 19.dp, end = 8.dp, top = 0.dp, bottom = 0.dp),
            fontSize = fontSize // Use fontSize parameter
        )

        IconButton(onClick = { updateItemCount(itemCount + 1) },
            modifier = Modifier.size(34.dp)
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Increase count",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}


private var shuffledJustForYouItems: List<Item>? = null

fun getShuffledJustForYouItems(itemsLists: List<List<Item>>): List<Item> {
    if (shuffledJustForYouItems == null) {
        // Flatten the list of lists, filter out only special items, and shuffle
        shuffledJustForYouItems = itemsLists.flatten().filter { it.special }.shuffled()
    }
    return shuffledJustForYouItems!!
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun homeSpecialItems(
    navController: NavHostController,
    itemsLists: List<List<Item>>,
) {
    val allSpecialItems = getShuffledJustForYouItems(itemsLists)

    // Flatten the list of lists and filter out only special items
   // val allSpecialItems = itemsLists.flatten().filter { it.special }.shuffled()

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 0.dp, top = 0.dp)
                .background(Color.Transparent),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(allSpecialItems) { item ->
            val type = item.type
            SpecialMenuItem(
                item = item,
                onDishClick = { itemID ->
                    navController?.navigate("ItemDetails/$itemID/$type")
                }
            )
        }
    }
}






//@Composable
//fun SpecialMenuItem(
//    dish: Item,
//    onDishClick: (Int) -> Unit
//) {
//    var itemCount by remember { mutableStateOf(CartManager.getItemCount(dish)) }
//    Card(
//        modifier = Modifier
//            .background(Color.White)
//            .width(180.dp)
//            .height(260.dp)
//            .padding(1.dp)
//            .clickable { onDishClick(dish.id) },
//        shape = RoundedCornerShape(16.dp),
//    ) {
//        Column(modifier = Modifier.background(Color.White)) {
//            Box(
//                modifier = Modifier
//                    .height(170.dp)
//                    .fillMaxWidth()
//            ) {
//                Image(
//                    painter = painterResource(id = dish.image),
//                    contentDescription = "Dish Image",
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .clip(RoundedCornerShape(25.dp))
//                )
//
//                Box(
//                    modifier = Modifier
//                        .matchParentSize() // This Box will match the size of the Image
//                ) {
//                    if (itemCount > 0) {
//                        //when it open
//                        CounterDisplay(
//                            itemCount = itemCount,
//                            updateItemCount = { newCount ->
//                                if (newCount > itemCount) {
//                                    CartManager.addItem(dish)
//                                } else {
//                                    CartManager.removeItem(dish)
//                                }
//                                itemCount = CartManager.getItemCount(dish)
//                            },
//                            modifier = Modifier
//                                .align(Alignment.BottomEnd)
//                                .padding(bottom = 8.dp, end = 8.dp)
//                        )
//                    } else {
//                        // when it closed
//                        IconButton(
//                            onClick = {
//                                CartManager.addItem(dish)
//                                itemCount = CartManager.getItemCount(dish)
//                            },
//                            modifier = Modifier
//                                .align(Alignment.BottomEnd)
//                                .padding(bottom = 8.dp, end = 8.dp)
//                                .size(48.dp)
//                                .background(Color.White, shape = CircleShape)
//                        ) {
//                            Icon(Icons.Default.Add, contentDescription = "Add")
//                        }
//                    }
//                }
//
//                // Weekly Special Tag
//                Box(
//                    modifier = Modifier
//                        .align(Alignment.TopEnd)
//                        .padding(top = 12.dp, end = 12.dp)
//                ) {
//                    Text(
//                        text = "Weekly Special",
//                        color = Color.White,
//                        modifier = Modifier
//                            .background(Color.Red, shape = RoundedCornerShape(4.dp))
//                            .padding(horizontal = 8.dp, vertical = 4.dp)
//                    )
//                }
//            }
//
//            // Dish Details
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Text(
//                    text = dish.name,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold
//                )
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(
//                        text = dish.price,
//                        fontSize = 15.sp,
//                        color = Color.Gray,
//                        fontWeight = FontWeight.SemiBold,
//                        textDecoration = TextDecoration.LineThrough
//                    )
//
//                    Spacer(modifier = Modifier.width(8.dp))
//
//                    Text(
//                        text = applyDiscount(dish.price, 2),
//                        fontSize = 15.sp,
//                        color = Color.Red,
//                        fontWeight = FontWeight.SemiBold
//                    )
//                }
//            }
//        }
//    }
//}

//@Composable
//fun SpecialMenuItem(dish: Item, onDishClick: (Int) -> Unit) {
//    var itemCount by remember { mutableStateOf(CartManager.getItemCount(dish)) }
//    Card(
//        modifier = Modifier.background(Color.White)
//            .width(180.dp)
//            .height(260.dp)
//            .padding(
//                start = 1.dp,
//                top = 6.dp,
//                end = 0.dp,
//                bottom = 1.dp
//            )
//            .clickable { onDishClick(dish.id) },
//        shape = RoundedCornerShape(16.dp),
//    ) {
//        Column( modifier = Modifier.background(Color.White)) {
//
//
//            Box(
//                modifier = Modifier
//                    .height(170.dp).background(Color.White)
//                    //    Set the height for the Box containing the image to match the height of the Image
//                    .fillMaxWidth()
//            ) {
//// Dish Image
//                Image(
//                    painter = painterResource(id = dish.image),
//                    contentDescription = "Dish Image",
//                    modifier = Modifier
//                        .fillMaxSize() // Fill the box size
//                        .clip(RoundedCornerShape(25.dp))
//                )
//                if (itemCount > 0) {
//                    CounterDisplay(
//                        itemCount = itemCount,
//                        updateItemCount = { newCount ->
//                            if (newCount > itemCount) {
//                                CartManager.addItem(dish)
//                            } else {
//                                CartManager.removeItem(dish)
//                            }
//                            itemCount = CartManager.getItemCount(dish)
//                        },
//                        modifier = Modifier
//                            .align(Alignment.BottomEnd)
//                            .padding(bottom = 16.dp, end = 16.dp)
//                    )
//                } else {
//                    IconButton(
//                        onClick = {
//                            CartManager.addItem(dish)
//                            itemCount = CartManager.getItemCount(dish)
//                        },
//                        modifier = Modifier
//                            .align(Alignment.BottomEnd)
//                            .padding(bottom = 16.dp, end = 16.dp)
//                            .size(48.dp)
//                            .background(Color.White, shape = CircleShape)
//                    ) {
//                        Icon(Icons.Default.Add, contentDescription = "Add")
//                    }
//                }
//
//// Overlay Green Card
//                Box(
//                    modifier = Modifier.background(Color.Transparent)
//                        .align(Alignment.TopEnd) // Aligns the box to the top end of the Image
//                        .padding(top = 12.dp, end = 12.dp) // Adjust the position as needed
//                ) {
//                    Card(
//                        shape = RoundedCornerShape(4.dp),
//                        modifier = Modifier.width(130.dp).height(27.dp)
//                            .background(Color.Transparent)
//                        //  .padding(horizontal = 19.dp, vertical = 3.dp)
//                    ) {
//                        Text(
//
//                            text = "Weekly Special", // Replace with your dynamic text if needed
//                            color = Color.White,
//                            fontSize = 13.sp,
//                            //   shape = RoundedCornerShape(8.dp),
//                            modifier = Modifier.background(Color.Red)
//                                //   .background(Color(0xFF0000))
//                                .width(130.dp).height(27.dp)
//                                .padding(horizontal = 19.dp, vertical = 3.dp) // Adjust text padding inside the tag
//                        )
//                    }
//                }
//            }
//
//            // Dish Details
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Text(
//                    text = dish.name,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(top = 8.dp).background(Color.White)
//                )
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(
//                        text = dish.price,
//                        fontSize = 15.sp,
//                        color = Color.Gray,
//                        fontWeight = FontWeight.SemiBold,
//                        textDecoration = TextDecoration.LineThrough,
//                        modifier = Modifier.padding(top = 4.dp).background(Color.White)
//                    )
//
//                    Spacer(modifier = Modifier.width(8.dp)) // Add space between the prices
//
//                    Text(
//                        text = applyDiscount(dish.price,2),
//                        fontSize = 15.sp,
//                        color = Color.Red,
//                        fontWeight = FontWeight.SemiBold,
//                        modifier = Modifier.padding(top = 4.dp).background(Color.White)
//                    )
//                }
//            }
//
//        }
//    }
//}




//@Composable
//fun SpecialMenuItem(
//    dish: Item,
//    onDishClick: (Int) -> Unit,
//    onAddToCartClick: (Item, Int) -> Unit // Callback when an item is added to the cart
//) {
//    var itemCount by remember { mutableStateOf(0) } // State to track the item count
//
//    Card(
//        modifier = Modifier
//            .background(Color.White)
//            .width(180.dp)
//            .height(260.dp)
//            .padding(1.dp)
//            .clickable { onDishClick(dish.id) },
//        shape = RoundedCornerShape(16.dp)
//    ) {
//        Column {
//            Box(
//                modifier = Modifier
//                    .height(170.dp)
//                    .fillMaxWidth()
//            ) {
//                Image(
//                    painter = painterResource(id = dish.image),
//                    contentDescription = "Dish Image",
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .clip(RoundedCornerShape(25.dp))
//                )
//
//                // Add the counter on top of the image at the bottom right
//                if (itemCount > 0) {
//                    CounterDisplay(
//                        itemCount = itemCount,
//                        updateItemCount = { newCount ->
//
//                            itemCount = newCount
//                            onAddToCartClick(dish, itemCount)
//                        }
//                        ,
//                        modifier = Modifier
//                            .align(Alignment.BottomEnd)
//                            .padding(bottom = 16.dp, end = 16.dp)
//                    )
//                } else {
//                    IconButton(
//                        onClick = {
//                            itemCount++
//                            onAddToCartClick(dish, itemCount)
//                        },
//                        modifier = Modifier
//                            .align(Alignment.BottomEnd)
//                            .padding(bottom = 16.dp, end = 16.dp)
//                            .size(48.dp)
//                            .background(Color.White, shape = CircleShape)
//                    ) {
//                        Icon(Icons.Default.Add, contentDescription = "Add")
//                    }
//                }
//            }
//
//            // Rest of the dish details
//            Text(
//                text = dish.name,
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.padding(16.dp)
//            )
//
//            Text(
//                text = "Price: ${dish.price}",
//                fontSize = 15.sp,
//                color = Color.Gray,
//                fontWeight = FontWeight.SemiBold,
//                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
//            )
//        }
//    }
//}




// this works fine before adding the + and -
//@Composable
//fun SpecialMenuItem(dish: Item, onDishClick: (Int) -> Unit) {
//    Card(
//        modifier = Modifier.background(Color.White)
//            .width(180.dp)
//            .height(260.dp)
//            .padding(
//                start = 1.dp,
//                top = 6.dp,
//                end = 0.dp,
//                bottom = 1.dp
//            )
//            .clickable { onDishClick(dish.id) },
//        shape = RoundedCornerShape(16.dp),
//    ) {
//        Column( modifier = Modifier.background(Color.White)) {
//            Box(
//                modifier = Modifier
//                    .height(170.dp).background(Color.White)
//                    //    Set the height for the Box containing the image to match the height of the Image
//                    .fillMaxWidth()
//            ) {
//// Dish Image
//                Image(
//                    painter = painterResource(id = dish.image),
//                    contentDescription = "Dish Image",
//                    modifier = Modifier
//                        .fillMaxSize() // Fill the box size
//                        .clip(RoundedCornerShape(25.dp))
//                )
//
//
//// Overlay Green Card
//                Box(
//                    modifier = Modifier.background(Color.Transparent)
//                        .align(Alignment.TopEnd) // Aligns the box to the top end of the Image
//                        .padding(top = 12.dp, end = 12.dp) // Adjust the position as needed
//                ) {
//                    Card(
//                        shape = RoundedCornerShape(4.dp),
//                        modifier = Modifier.width(130.dp).height(27.dp)
//                            .background(Color.Transparent)
//                        //  .padding(horizontal = 19.dp, vertical = 3.dp)
//                    ) {
//                        Text(
//
//                            text = "Weekly Special", // Replace with your dynamic text if needed
//                            color = Color.White,
//                            fontSize = 13.sp,
//                            //   shape = RoundedCornerShape(8.dp),
//                            modifier = Modifier.background(Color.Red)
//                                //   .background(Color(0xFF0000))
//                                .width(130.dp).height(27.dp)
//                                .padding(horizontal = 19.dp, vertical = 3.dp) // Adjust text padding inside the tag
//                        )
//                    }
//                }
//            }
//
//            // Dish Details
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Text(
//                    text = dish.name,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(top = 8.dp).background(Color.White)
//                )
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(
//                        text = dish.price,
//                        fontSize = 15.sp,
//                        color = Color.Gray,
//                        fontWeight = FontWeight.SemiBold,
//                        textDecoration = TextDecoration.LineThrough,
//                        modifier = Modifier.padding(top = 4.dp).background(Color.White)
//                    )
//
//                    Spacer(modifier = Modifier.width(8.dp)) // Add space between the prices
//
//                    Text(
//                        text = applyDiscount(dish.price,2),
//                        fontSize = 15.sp,
//                        color = Color.Red,
//                        fontWeight = FontWeight.SemiBold,
//                        modifier = Modifier.padding(top = 4.dp).background(Color.White)
//                    )
//                }
//            }
//
//        }
//    }
//}


// this one works perfectly before adding the + and - signs
//@Composable
//fun MenuItem(item: Item, onDishClick: (Int) -> Unit, backgroundColor: Color = Color(0xFFFFFFFF)) {
//    Card(
//        modifier = Modifier
//            .padding(2.dp) // Adds padding around the Card
//            .clickable { onDishClick(item.id) }
//    ) {
//        Box(
//
//            modifier = Modifier
//                .background(backgroundColor)
//                .fillMaxWidth()
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(end = 8.dp)
//                ) {
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(
//                            text = item.name,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                        if (item.special) {
//                            Spacer(modifier = Modifier.width(8.dp)) // Space between the name and the special tag
//                            Box(
//                                contentAlignment = Alignment.Center,
//                                modifier = Modifier
//                                    .clip(RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp))
//                                    .background(Color.Red)
//                                    .padding(vertical = 4.dp, horizontal = 8.dp)
//                            ) {
//                                Text(
//                                    text = "SPECIAL",
//                                    color = Color.White,
//                                    fontSize = 12.sp,
//
//                                    fontWeight = FontWeight.Bold
//                                )
//                            }
//                        }
//                    }
//
//                            Text(
//                                text = item.description,
//                                color = Color.Gray,
//                                modifier = Modifier
//                                    .padding(top = 5.dp, bottom = 5.dp)
//                            )
//
//                    // Conditional display of price based on whether dish is special
//                    if (item.special) {
//                        // Apply the discount
//                        val discountedPrice =
//                            applyDiscount(item.price, 2) // Assuming the discount is $2
//
//                        Row(
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Text(
//                                text = item.price,
//                                fontSize = 15.sp,
//                                color = Color.Gray,
//                                fontWeight = FontWeight.SemiBold,
//                                textDecoration = TextDecoration.LineThrough
//                            )
//
//                            Spacer(modifier = Modifier.width(8.dp))
//
//                            Text(
//                                text = discountedPrice,
//                                fontSize = 15.sp,
//                                color = Color.Red,
//                                fontWeight = FontWeight.SemiBold
//                            )
//                        }
//                    } else {
//                        // Display the normal price when not special
//                        Text(
//                            text = item.price,
//                            fontSize = 15.sp,
//                            color = Color.Gray,
//                            fontWeight = FontWeight.SemiBold
//                        )
//                    }
//                }
//                Image(
//                    painter = painterResource(id = item.image),
//                    contentDescription = "Dish image",
//                    modifier = Modifier
//                        .size(120.dp)
//                        .clip(RoundedCornerShape(14.dp))
//                )
//            }
//        }
//    }
//}
//




//
//@Composable
//fun MenuDish(dish: Dish, onDishClick: (Int) -> Unit, backgroundColor: Color = Color(0xFFFFFFFF)) {
//    Card(
//        modifier = Modifier
//            .padding(2.dp) // Adds padding around the Card
//            .clickable { onDishClick(dish.id) }
//    ) {
//        Box(
//            modifier = Modifier
//                .background(backgroundColor)
//                .fillMaxWidth()
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//            ) {
//                Column {
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                        Text(
//                            text = dish.name,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                        if (dish.special) {
//                            Spacer(modifier = Modifier.width(8.dp)) // Space between the name and the special tag
//                            Box(
//                                contentAlignment = Alignment.Center,
//                                modifier = Modifier
//                                    .clip(RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp))
//                                    .background(Color.Red)
//                                    .padding(vertical = 4.dp, horizontal = 8.dp)
//                            ) {
//                                Text(
//                                    text
//                                    ="SPECIAL",
//                                    color = Color.White,
//                                    fontSize = 12.sp,
//                                    fontWeight = FontWeight.Bold
//                                )
//                            }
//                        }
//                    }
//
//                            Text(
//                                text = dish.description,
//                                color = Color.Gray,
//                                modifier = Modifier
//                                    .padding(top = 5.dp, bottom = 5.dp)
//                                    .fillMaxWidth(.75f)
//                            )
//
//                    // Conditional display of price based on whether dish is special
//                    if (dish.special) {
//                        // Apply the discount
//                        val discountedPrice = applyDiscount(dish.price, 2) // Assuming the discount is $2
//
//                        Row(
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Text(
//                                text = dish.price,
//                                fontSize = 15.sp,
//                                color = Color.Gray,
//                                fontWeight = FontWeight.SemiBold,
//                                textDecoration = TextDecoration.LineThrough
//                            )
//
//                            Spacer(modifier = Modifier.width(8.dp))
//
//                            Text(
//                                text = discountedPrice,
//                                fontSize = 15.sp,
//                                color = Color.Red,
//                                fontWeight = FontWeight.SemiBold
//                            )
//                        }
//                    } else {
//                        // Display the normal price when not special
//                        Text(
//                            text = dish.price,
//                            fontSize = 15.sp,
//                            color = Color.Gray,
//                            fontWeight = FontWeight.SemiBold
//                        )
//                    }
//                }
//                Image(
//                    painter = painterResource(id = dish.image),
//                    contentDescription = "Dish image",
//                    modifier = Modifier
//                        .size(100.dp)
//                            .clip(RoundedCornerShape(14.dp))
//                )
//            }
//        }
//    }
//}

//@Composable
//fun MenuDish(dish: Dish, onDishClick: (Int) -> Unit, backgroundColor: Color = Color(0xFFFFFFFF)) {
//    Card(
//        modifier = Modifier
//            .padding(2.dp) // Adds padding around the Card
//            .clickable { onDishClick(dish.id) }
//    ) {
//        Box(
//            modifier = Modifier
//                .background(backgroundColor)
//                .fillMaxWidth()
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//            ) {
//                Column {
//
//                            // Check if dish is on special and display a red card/tag
//                            if (dish.special) {
//                                Box(
//                                    contentAlignment = Alignment.Center,
//                                    modifier = Modifier
//                                       // .align(Alignment.TopStart)
//                                        .clip(RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp))
//                                        .background(Color.Red)
//                                        .padding(vertical = 4.dp, horizontal = 8.dp)
//                                ) {
//                                    Text(
//                                        text = "SPECIAL",
//                                        color = Color.White,
//                                        //style = MaterialTheme.typography.caption
//                                    )
//                                }
//                            }
//
//                    Text(
//                        text = "${dish.name}",
//                        fontSize = 16.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                    Text(
//                        text = dish.description,
//                        color = Color.Gray,
//                        modifier = Modifier
//                            .padding(top = 5.dp, bottom = 5.dp)
//                            .fillMaxWidth(.75f)
//                    )
//
//                    // Conditional display of price based on whether dish is special
//                    if (dish.special) {
//                        // Apply the discount
//                        val discountedPrice = applyDiscount(dish.price, 2)
//
//                        Row(
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Text(
//                                text = dish.price,
//                                fontSize = 15.sp,
//                                color = Color.Gray,
//                                fontWeight = FontWeight.SemiBold,
//                                textDecoration = TextDecoration.LineThrough
//                            )
//
//                            Spacer(modifier = Modifier.width(8.dp))
//
//                            Text(
//                                text = discountedPrice,
//                                fontSize = 15.sp,
//                                color = Color.Red,
//                                fontWeight = FontWeight.SemiBold
//                            )
//                        }
//                    } else {
//                        // Display the normal price when not special
//                        Text(
//                            text = dish.price,
//                            fontSize = 15.sp,
//                            color = Color.Gray,
//                            fontWeight = FontWeight.SemiBold
//                        )
//                    }
//                }
//                Image(
//                    painter = painterResource(id = dish.image),
//                    contentDescription = "Dish image",
//                    modifier = Modifier.size(100.dp)
//                        .clip(RoundedCornerShape(14.dp))
//                )
//            }
//        }
//    }
//}





//
//@Composable
//fun MenuDish(dish: Dish, onDishClick: (Int) -> Unit,  backgroundColor: Color = Color(0xFFFFFFFF)) {
//    //backgroundColor: Color = Color(0xFFececec)
//    Card(
//        modifier = Modifier.padding(2.dp)// Adds padding around the Card
//            .clickable { onDishClick(dish.id) },
//
//        ){
//        Box(
//
//            modifier = Modifier
//                .background(backgroundColor)
//                .fillMaxWidth()
//        )
//        {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//            ) {
//                Column {
//                    Text(
//                        text = "${dish.name}",
//                        fontSize = 16.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                    Text(
//                        text = dish.description,
//                        color = Color.Gray,
//                        modifier = Modifier
//                            .padding(top = 5.dp, bottom = 5.dp)
//                            .fillMaxWidth(.75f)
//                    )
//                    Text(
//                        text = dish.price,
//                        fontSize = 15.sp,
//                        color = Color.Gray,
//                        fontWeight = FontWeight.SemiBold
//                    )
//                }
//                Image(
//                    painter = painterResource(id = dish.image),
//                    contentDescription = "img",
//                    modifier = Modifier.size(100.dp)
//                        .clip(RoundedCornerShape(14.dp))
//                )
//            }
//        }
//    }
//}


//@Composable
//fun SpecialMenuDish(dish: Dish, onDishClick: (Int) -> Unit) {
//    Card(
//        modifier = Modifier
//            .width(180.dp)
//            .height(260.dp)
//            .padding(
//                start = 1.dp,
//                top = 6.dp,
//                end = 0.dp,
//                bottom = 1.dp
//            )
//            .clickable { onDishClick(dish.id) },
//        shape = RoundedCornerShape(16.dp),
//       // elevation = 4.dp
//    ) {
//        Box {
//            // Dish Image
//            Image(
//                painter = painterResource(id = dish.image),
//                contentDescription = "Dish Image",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(170.dp)
//                    .clip(RoundedCornerShape(25.dp))
//            )
//            // Overlay Green Card
//            Box(
//                modifier = Modifier
//                    .align(Alignment.TopEnd) // Aligns the box to the top end of the Image
//                    .padding(top = 12.dp, end = 12.dp) // Adjust the position as needed
//            ) {
//                Card(
//                    //backgroundColor = Color.Green,
//                    shape = RoundedCornerShape(4.dp),
//                    modifier = Modifier
//                        .padding(4.dp) // Adjust the padding to position your tag
//                        .background(Color.Green,  shape = RoundedCornerShape(14.dp)).clip(RoundedCornerShape(25.dp))
//                ) {
//                    Text(
//                        text = "#2 most liked", // Replace with your dynamic text if needed
//                        color = Color.Black,
//                        fontSize = 12.sp,
//                        modifier = Modifier
//                            .padding(horizontal = 9.dp, vertical = 4.dp) // Adjust text padding inside the tag
//                    )
//                }
//            }
//
//
//            // Dish Details
//            Column(
//                modifier = Modifier
//                    .align(Alignment.BottomStart)
//                    .padding(16.dp)
//            ) {
//                Text(
//                    text = dish.name,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(top = 3.dp).align(Alignment.Start)
//                )
//                Text(
//                    text = dish.price,
//                    fontSize = 15.sp,
//                    color = Color.Gray,
//                    fontWeight = FontWeight.SemiBold,
//                    modifier = Modifier.padding(top = 3.dp).align(Alignment.Start)
//                )
//            }
//        }
//    }
//}




//
//@Composable
//fun SpecialMenuDish(dish: Dish, onDishClick: (Int) -> Unit, backgroundColor: Color = Color(0xFFFFFFFF)){
//    Card(
//        modifier = Modifier.width(180.dp).height(260.dp)
//            .background(Color.White)
//            .padding(
//                start = 1.dp,
//                top = 6.dp,
//                end = 0.dp,
//                bottom = 1.dp
//            )
//            .clickable { onDishClick(dish.id) },
//        shape = RoundedCornerShape(16.dp),
//
//    ) {
//        Box(
//
//            modifier = Modifier
//                .background(Color.White)
//                .fillMaxWidth()
//        )
//        Column(
//            modifier = Modifier
//                .fillMaxWidth().background(Color.White)
//                .padding(16.dp)
//        ) {
//
//            Image(
//
//                painter = painterResource(id = dish.image),
//                contentDescription = "Dish Image",
//                modifier = Modifier
//                    .padding(top = 1.dp)
//                    .background(Color.White)
//                    .fillMaxWidth()
//                    .height(170.dp)
//                    .clip(RoundedCornerShape(25.dp))
//            )  // Overlay the green card on the Image here
//            Box(
//                modifier = Modifier
//                    .align(Alignment.End) // Aligns the box to the top end of the Image
//                    .padding(top = 12.dp, end = 12.dp) // Adjust the position as needed
//            ) {
//                Card(
//
//                    modifier = Modifier.background(Color.Transparent)
//                        .align(Alignment.TopEnd)
//                        .padding(end = 8.dp, top = 8.dp) // Adjust the padding to position your tag
//                ) {
//                    Text(
//                        text = "#2 most liked", // Replace with your dynamic text if needed
//                        color = Color.Black,
//                        fontSize = 12.sp,
//                        modifier = Modifier.padding(end = 0.dp, top = 0.dp, start = 0.dp) // Adjust text padding inside the tag
//                            .background(Color.Green,  shape = RoundedCornerShape(14.dp)).clip(RoundedCornerShape(25.dp))
//
//                    )
//                }
//            }
//
//            Text(
//                text = dish.name,
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier
//                    .align(Alignment.Start)
//                    .padding(top = 3.dp)
//
//            )
//            Text(
//                text = dish.price,
//                fontSize = 15.sp,
//                color = Color.Gray,
//                fontWeight = FontWeight.SemiBold,
//                modifier = Modifier
//                    .align(Alignment.Start)
//                    .padding(top = 3.dp)
//            )
//        }
//    }
//}

//@Composable
//fun SpecialMenuDish(dish: Dish, onDishClick: (Int) -> Unit,  backgroundColor: Color = Color(0xFFFFFFFF)) {
//    Card(
//        modifier = Modifier
//            .padding(8.dp)
//            .clickable { onDishClick(dish.id) },
//       // elevation = 4.dp,
//        shape = RoundedCornerShape(16.dp) // More pronounced rounded corners for special dishes
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(backgroundColor) // Using theme surface color
//                .padding(16.dp)
//        ) {
//            Image(
//                painter = painterResource(id = dish.image),
//                contentDescription = "Dish Image",
//                modifier = Modifier
//                    .size(100.dp)
//                    .clip(RoundedCornerShape(8.dp)) // Rounded corners for the image
//                 //   .align(LineHeightStyle.Alignment.CenterVertically)
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            Column(
//                modifier = Modifier
//               //     .align(LineHeightStyle.Alignment.CenterVertically)
//                    .fillMaxWidth()
//            ) {
//                Text(
//                    text = dish.name,
//                    style = MaterialTheme.typography.headlineLarge, // Using theme typography for consistency
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = dish.description,
//                    style = MaterialTheme.typography.displaySmall, // Using body2 typography, which is typically used for secondary text in Material Design
//                    color = Color.Gray,
//                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
//                )
//                Text(
//                    text = dish.price,
//                    style = MaterialTheme.typography.bodyLarge, // Using subtitle1 typography, which is typically used for emphasized text
//                  // color = MaterialTheme.colors.primary, // Using primary color to highlight the price
//                    fontWeight = FontWeight.Medium
//                )
//            }
//        }
//    }
//}
//
@Preview(showBackground = true)
@Composable
fun PreviewSpecialMenuItem() {
    // Sample data for the preview
    val sampleDish = Item(
        "fruits",
        id = 1,
        name = "Deluxe Pizza",
        price = 15.99,
        description = "A delicious pizza with the finest mozzarella cheese, fresh tomatoes, and homemade pepperoni.",
        image = R.drawable.greeksalad, // Replace with a sample image resource
        category = "Most Liked",
        special = false,
        2
    )

    // Setting up a mock function for click handling in the preview
    val onDishClick: (Int) -> Unit = { dishId ->
        println("Dish clicked: $dishId")
    }

    // Set up a theme if you are using MaterialTheme in your composable
    MaterialTheme {
   //     SpecialMenuItem(dish = sampleDish, onDishClick = onDishClick)
    }
}