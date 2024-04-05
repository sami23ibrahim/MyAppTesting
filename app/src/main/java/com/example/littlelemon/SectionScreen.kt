package com.example.littlelemon
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.data.Categories
import com.example.littlelemon.data.CategoryIcon
import com.example.littlelemon.data.Item
import com.example.littlelemon.data.MenuItem
import com.example.littlelemon.data.SpecialMenuItem
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.roundToInt

@SuppressLint("SuspiciousIndentation")
@Composable
fun SectionScreen(navController: NavHostController,
                  listOfItems: List<Item>,
                  listOfCategories: List<Categories>,
                  sectionImg:String,
                  listTypeName: String
                 )
{

    // val context = LocalContext.current
    val switchThreshold = 350
    val scrollState = rememberScrollState()
    val iconScrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val selectedCategory = remember { mutableStateOf(listOfCategories.first().name) }
    val categoryPositions = remember { mutableMapOf<String, MutableState<Int>>() }

    BoxWithConstraints {
        val iconRowOffset = remember { mutableStateOf(0.dp) }
        val localDensity = LocalDensity.current
        // Assuming the height of the image
        val imageHeight = 110.dp
        val imageHeightPx = with(localDensity) { imageHeight.toPx() }
        val additionalOffsetPx = with(localDensity) { 0.dp.toPx() } // Convert 20.dp to pixels

        LaunchedEffect(scrollState.value) {
            // Calculate the scroll position at which the icons row should stick to the top
            val stickyPositionPx = imageHeightPx + additionalOffsetPx // Add additional offset here
            // Calculate the offset based on the current scroll position, adjusting with the additional offset
            val offsetPx = if (scrollState.value > stickyPositionPx - additionalOffsetPx) {
                additionalOffsetPx // Apply additional offset to push it down
            } else {
                -(stickyPositionPx - scrollState.value - additionalOffsetPx) // Adjust calculation here
            }
            iconRowOffset.value = with(localDensity) { offsetPx.toDp() }
        }

        Image(
            painter = painterResource(id = R.drawable.screen),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
    Column(modifier = Modifier.verticalScroll(scrollState)
            .padding(top = 30.dp, bottom = 0.dp)
        ) {
// Use LocalContext to access the resources
        val context = LocalContext.current
        // Convert the name of the drawable to a resource ID
        val imageResId = context.resources.getIdentifier(sectionImg, "drawable", context.packageName)

        Row(
            modifier = Modifier
                .fillMaxWidth() // Fill the width of the parent
             //   .padding(end = 15.dp) // Apply end padding to the entire Row
                .padding(start = 85.dp,end=55.dp)
        ) {
           // Spacer(modifier = Modifier.width(10.dp)) // This moves the contents a bit to the right
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Section Image",
                modifier = Modifier
                    .size(100.dp) // Set the size of the image
                    .padding(end = 16.dp) // Apply end padding to the image
                    .align(Alignment.Top) // Align the image to the top of the Row
            )

            Text(
                text = listTypeName,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(Alignment.CenterVertically) // Ensure the Text is also aligned to the top of the Row
                    .padding(start = 16.dp) // Add start padding to the text if needed
            )
        }

        Spacer(modifier = Modifier.height(20.dp)) // This moves the contents a bit to the right

        SearchBar(
            navController = navController,
            listOfItems = listOfItems,
            placeholderText = "Search "+ listTypeName + ".."// Placeholder text can still be dynamically adjusted as needed
        )

            listOfCategories.forEach { category ->

                val positionState = categoryPositions.getOrPut(category.name) { mutableStateOf(0) }
                // Filter the items for the current category
                val itemsInCategory = listOfItems.filter { it.category == category.name }

                // Only proceed if there are items in this category
                if (itemsInCategory.isNotEmpty() || (category.name == "Weekly Specials")) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .onPlaced { layoutCoordinates ->
                                positionState.value =
                                    layoutCoordinates.positionInParent().y.roundToInt()
                            }
                    ) {
                        Text(
                            text = category.name,
                            modifier = Modifier.padding(
                                start = 30.dp,
                                top = 15.dp,
                                end = 0.dp,
                                bottom = 0.dp
                            ),
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )


                    }
// Check if the category is "Weekly Specials" to use LazyRow for horizontal scrolling

                        if (category.name == "Weekly Specials") {
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 0.dp, top = 0.dp),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            items(listOfItems.filter { it.special }) { dish ->
                                val type = dish.type
                       //         Spacer(modifier = Modifier.height(105.dp)) // Space above search bar
                                SpecialMenuItem(
                                    item = dish,

                                    onDishClick = { itemID ->
                                        navController?.navigate("ItemDetails/$itemID/$type")
                                    }
                                )

                            }

                        }

                      //  Divider(color = Color.LightGray, thickness = 1.6.dp)
                    } else {
// For other categories, list the dishes one above the other

                        listOfItems.filter { it.category == category.name }.forEach { item ->
                            val type = item.type
                            MenuItem(
                                item,
                                onDishClick = { itemID ->
                                    navController.navigate("ItemDetails/$itemID/${item.type}")
                                }
                            )
                        //    Divider(color = Color.LightGray, thickness = 0.8.dp)

                        }

                    }
                }
            }
        Spacer(modifier = Modifier.height(186.dp)) // Adjust the height as needed

    }

// filter the categories that have items or are "Weekly Specials".
        val categoriesWithItems = listOfCategories.filter { category ->
            listOfItems.any { it.category == category.name } || category.name == "Weekly Specials"
        }

        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(y = iconRowOffset.value)
                .fillMaxWidth()
                .background(Color.White)
                .horizontalScroll(iconScrollState)
                .padding(bottom = 0.dp, top = 0.dp)
        ) {
//using the filtered list in the Row composable.
            categoriesWithItems.forEach { (category, imageResId) ->
                // listOfCategories.forEach { (category, imageResId) ->

                CategoryIcon(category, imageResId, selectedCategory.value == category) {
                    selectedCategory.value = category
                    if (category == "Weekly Specials") {
                        coroutineScope.launch {
                           // scrollState.animateScrollTo(320) // Scrolls to the top
                            scrollState.animateScrollTo(0)
                        }
                    } else {
                        categoryPositions[category]?.let { positionState ->
                            coroutineScope.launch {
                                // Keep the original logic for other categories
                                scrollState.animateScrollTo(positionState.value - 390)
                            }
                        }
                    }
                }
            }

        }

    }
        // Auto-scroll the icons row to the selected category icon logic
        val iconWidth = 56.dp + (8.dp * 2)
        val iconWidthPx = with(LocalDensity.current) { iconWidth.toPx() }

        LaunchedEffect(selectedCategory.value) {
           // val selectedIndex = Categories.keys.indexOf(selectedCategory.value)
            val selectedIndex = listOfCategories.indexOfFirst { it.name == selectedCategory.value }

            val scrollToPosition = ((selectedIndex * iconWidthPx) - (iconScrollState.maxValue / 2)).toInt().coerceIn(0, iconScrollState.maxValue)
            coroutineScope.launch {
                iconScrollState.animateScrollTo(scrollToPosition)
            }
        }



        LaunchedEffect(scrollState) {
            snapshotFlow { scrollState.value }
                .collect { scrollPosition ->
                    val activeCategory = categoryPositions.entries
                        .firstOrNull { (_, position) ->
                            val distanceFromTop = abs(position.value - scrollPosition)
                            distanceFromTop < switchThreshold
                        }?.key

                    activeCategory?.let {
                        if (it != selectedCategory.value) {
                            selectedCategory.value = it
                        }
                    }
                }
        }

}




//
//@Composable
//fun SectionScreen(navController: NavHostController) {
//    val switchThreshold = 10
//    val scrollState = rememberScrollState()
//    val iconScrollState = rememberScrollState()
//    val coroutineScope = rememberCoroutineScope()
//    val selectedCategory = remember { mutableStateOf(Categories.keys.first()) }
//    val categoryPositions = remember { mutableMapOf<String, MutableState<Int>>() }
//
//    // Calculate the alpha value for the image based on the scroll position
//    val imageAlpha = if (scrollState.value > 300) 0f else 1f - (scrollState.value / 300f)
//
//
//
//    Column(modifier = Modifier.verticalScroll(scrollState)) {
//        Image(
//            painter = painterResource(id = R.drawable.grillades),
//            contentDescription = "Header Image",
//            modifier = Modifier
//                .fillMaxWidth()
//                .alpha(imageAlpha) // Apply the dynamic alpha value here
//        )
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .horizontalScroll(iconScrollState)
//                .background(Color.White)
//                .padding(bottom = 0.dp, top = 0.dp)
//        ) {
//            Categories.forEach { (category, imageResId) ->
//                MenuCategory(category, imageResId, selectedCategory.value == category) {
//                    selectedCategory.value = category
//                    categoryPositions[category]?.let { positionState ->
//                        coroutineScope.launch {
//                            scrollState.animateScrollTo(positionState.value)
//                        }
//                    }
//                }
//            }
//        }
//
//        Categories.keys.forEach { category ->
//            // Create or get the MutableState to hold the Y position
//            val positionState = categoryPositions.getOrPut(category) { mutableStateOf(0) }
//
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .onPlaced { layoutCoordinates ->
//                        // Update the Y position when the layout is placed
//                        positionState.value = layoutCoordinates.positionInParent().y.roundToInt()
//                    }
//            ) {
//                Text(
//                    text = category,
//                    modifier = Modifier.padding(16.dp),
//                    textAlign = TextAlign.Center
//                )
//                Divider(color = Color.Red, thickness = 1.dp)
//            }
//
//            // Dishes for each category
//            dishes.forEach { dish ->
//                if (dish.category == category) {
//                    MenuDish(dish, onDishClick = { dishId ->
//                        if (navController != null) {
//                            navController.navigate("dishDetails/$dishId")
//                        }
//                    })
//                }
//            }
//        }
//
//        // Auto-scroll the icons row to the selected category icon logic
//        val iconWidth = 56.dp + (8.dp * 2) // Width of Box plus horizontal padding on both sides
//        val iconWidthPx = with(LocalDensity.current) { iconWidth.toPx() } // Convert to pixels
//
//        LaunchedEffect(selectedCategory.value, iconWidthPx) {
//            val selectedIndex = Categories.keys.indexOf(selectedCategory.value)
//
//            coroutineScope.launch {
//                val scrollToPosition = ((selectedIndex * iconWidthPx) - (iconScrollState.maxValue / 2)).toInt()
//                iconScrollState.animateScrollTo(scrollToPosition.coerceIn(0, iconScrollState.maxValue))
//            }
//        }
//
//        // Update selected category based on scroll position
//        LaunchedEffect(scrollState) {
//            snapshotFlow { scrollState.value }
//                .collect { scrollPosition ->
//                    val activeCategory = categoryPositions.entries
//                        .firstOrNull { (_, position) ->
//                            abs(position.value - (scrollPosition + switchThreshold)) < 100
//                        }?.key
//
//                    activeCategory?.let {
//                        selectedCategory.value = it
//                    }
//                }
//        }
//    }
//}


//*********** dont delete below this line***************************************
//@Composable
//fun SectionScreen(navController: NavHostController) {
//    val lazyListState = rememberLazyListState()
//    val coroutineScope = rememberCoroutineScope()
//    val selectedCategory = remember { mutableStateOf(Categories.keys.first()) }
//    val scrollState = rememberScrollState()
//    val fixedHeaderHeight =180 // Fixed height from the top of the screen
//    FullWidthImage(imageId = R.drawable.grillades, imageHeight = 84.dp)
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .horizontalScroll(scrollState)
//                .background(Color.White)
//                .padding(bottom = 6.dp, top = 0.dp)
//        ) {
//            Categories.forEach { (category, imageResId) ->
//                MenuCategory(category, imageResId, selectedCategory.value == category) {
//                    coroutineScope.launch {
//                        val categoryIndex = Categories.keys.indexOf(category) *3
//                        lazyListState.animateScrollToItem(categoryIndex)
//                        selectedCategory.value = category
//                    }
//                }
//            }
//        }
//        Box {
//            LazyColumn(state = lazyListState) {
//                Categories.keys.forEachIndexed { index, category ->
//                    item(key = category) {
//                        CategoryHeader(category)
//                    }
//
//                    items(dishes) { dish ->
//                        MenuDish(dish, onDishClick = { dishId ->
//                if (navController != null) {
//                    navController.navigate("dishDetails/$dishId")
//                }
//                                                     }
//                        )
//                    }
//
//                }
//            }
//        }
//        LaunchedEffect(lazyListState.layoutInfo) {
//            val visibleItem = lazyListState.layoutInfo.visibleItemsInfo
//                .firstOrNull { itemInfo ->
//                    itemInfo.key != null && itemInfo.key is String && Categories.keys.contains(
//                        itemInfo.key as String
//                    )
//                }
//            visibleItem?.let { itemInfo ->
//                if (itemInfo.offset <= fixedHeaderHeight && selectedCategory.value != itemInfo.key as String) {
//                    selectedCategory.value = itemInfo.key as String
//                }
//            }
//        }
//    }

//**********************************************************************************************

//@SuppressLint("SuspiciousIndentation")
//@Preview(showBackground = true)
//@Composable
//fun MenuDishPreview() {
//  val dish=  Dish(1,"testing"
//        , "$12.99"
//        , "Home made Greek Salad, lettuce, peppers, olives and our special cheese"
//        ,R.drawable.greek,"pizza"
//  )
//    MenuDish(dish, onDishClick = { dishId ->
//        // Define what happens when a dish is clicked
//        // For example, navigate to a details screen
//    })
//}
//@Preview(showBackground = true)
//@Composable
//fun MenuCategoryPreview() {
//    // Example usage of MenuCategory
//    MenuCategory(
//        category = "category",
//        imageResId = R.drawable.pizza2,
//        isSelected = true,
//        onClick = { /* Define what happens when the MenuCategory is clicked */ }
//    )
//}