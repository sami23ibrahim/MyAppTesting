package com.example.littlelemon

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.littlelemon.data.Item
@Composable
fun SearchBar(
    navController: NavController,
    listOfItems: List<Item>,
    placeholderText: String
) {
    var searchText by remember { mutableStateOf("") }
    var showSuggestions by remember { mutableStateOf(false) }

    val suggestions = if (searchText.isNotEmpty()) {
        listOfItems.filter { it.name.contains(searchText, ignoreCase = true) }
            .sortedBy { it.name }
            .take(3)
    } else {
        emptyList()
    }

    LaunchedEffect(searchText) {
        showSuggestions = suggestions.isNotEmpty()
    }

    Box(
        modifier = Modifier
            .padding(
                top = 0.dp,    // Replace with your desired value for top padding
                bottom = 30.dp, // Replace with your desired value for bottom padding
                start = 20.dp,  // Replace with your desired value for start (left) padding
                end = 20.dp     // Replace with your desired value for end (right) padding
            )
    ) {
        Column {
            // Add a Surface with elevation to create the shadow effect
            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp), // Adjust this to match the rounded corner radius of your design
                elevation = 38.dp // This adds the shadow
            ) {
                TextField(
                    value = searchText,
                    onValueChange = {
                        searchText = it
                        showSuggestions = true
                    },
                    placeholder = { Text(placeholderText) },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, RoundedCornerShape(50)), // Adjust for rounded corners
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        cursorColor = Color.Black,
                        leadingIconColor = Color.Gray,
                        placeholderColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    singleLine = true
                )
            }

            // Suggestions dropdown
            if (showSuggestions) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .wrapContentHeight()
                ) {
                    suggestions.forEach { suggestion ->
                        Text(
                            text = suggestion.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navController.navigate("ItemDetails/${suggestion.id}/${suggestion.type}")
                                    searchText = ""
                                    showSuggestions = false
                                }
                                .padding(16.dp)
                        )
                    }
                }
            }
        }

        if (searchText.isNotEmpty() && suggestions.isEmpty()) {
            Text(
                "No items found",
                modifier = Modifier
                    .padding(start = 16.dp, top = 72.dp)
                    .fillMaxWidth()
            )
        }
    }
}

//@Composable
//fun SearchBar(
//    navController: NavController,
//    listOfItems: List<Item>,
//    placeholderText: String
//) {
//    var searchText by remember { mutableStateOf("") }
//    var showSuggestions by remember { mutableStateOf(false) }
//
//    val suggestions = if (searchText.isNotEmpty()) {
//        listOfItems.filter { it.name.contains(searchText, ignoreCase = true) }
//            .sortedBy { it.name }
//            .take(3)
//    } else {
//        emptyList()
//    }
//
//    LaunchedEffect(searchText) {
//        showSuggestions = suggestions.isNotEmpty()
//    }
//
//    Box(
//        modifier = Modifier
//            .padding(16.dp) // Add padding around the entire Box
//    ) {
//        Column {
//            TextField(
//                value = searchText,
//                onValueChange = {
//                    searchText = it
//                    showSuggestions = true
//                },
//                placeholder = { Text(placeholderText) },
//                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(Color.White, RoundedCornerShape(50)), // Rounded corners
//                colors = TextFieldDefaults.textFieldColors(
//                    backgroundColor = Color.White,
//                    cursorColor = Color.Black,
//                    leadingIconColor = Color.Gray,
//                    placeholderColor = Color.Gray,
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent
//                ),
//                singleLine = true,
//                textStyle = TextStyle(color = Color.Black)
//            )
//
//            // Suggestions dropdown
//            if (showSuggestions) {
//                // Additional styling may be required here to match your design
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color.White)
//                ) {
//                    suggestions.forEach { suggestion ->
//                        Text(
//                            text = suggestion.name,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .clickable {
//                                    navController.navigate("ItemDetails/${suggestion.id}/${suggestion.type}")
//                                    searchText = ""
//                                    showSuggestions = false
//                                }
//                                .padding(16.dp)
//                        )
//                    }
//                }
//            }
//        }
//
//        if (searchText.isNotEmpty() && suggestions.isEmpty()) {
//            Text(
//                "No items found",
//                modifier = Modifier
//                    .padding(start = 16.dp, top = 72.dp) // Adjust padding to match your design
//                    .fillMaxWidth()
//            )
//        }
//    }
//}
//
//@Composable
//fun SearchBar(
//    navController: NavController,
//    listOfItems: List<Item>,
//    placeholderText: String
//) {
//    var searchText by remember { mutableStateOf("") }
//    var showSuggestions by remember { mutableStateOf(false) }
//
//    val suggestions = if (searchText.isNotEmpty()) {
//        listOfItems.filter { it.name.contains(searchText, ignoreCase = true) }
//            .sortedBy { it.name }
//            .take(3)
//    } else {
//        emptyList()
//    }
//
//    LaunchedEffect(searchText) {
//        showSuggestions = suggestions.isNotEmpty()
//    }
//
//    Box {
//        Column {
//            TextField(
//                value = searchText,
//                onValueChange = {
//                    searchText = it
//                    showSuggestions = true
//                },
//                placeholder = { Text(placeholderText) },
//                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
//                // Adjust TextField modifiers as needed
//                // Other TextField parameters
//            )
//
//            // Suggestions dropdown
//            if (showSuggestions) {
//                Column(
//                    // Column modifiers
//                ) {
//                    suggestions.forEach { suggestion ->
//                        Text(
//                            text = suggestion.name,
//                            modifier = Modifier
//                                .clickable {
//                                    // Navigate to the item details screen when a suggestion is clicked
//                                    navController.navigate("ItemDetails/${suggestion.id}/${suggestion.type}")
//                                    searchText = "" // Clear the search text
//                                    showSuggestions = false // Hide the suggestions dropdown
//                                }
//                                .padding(16.dp) // Adjust padding as needed
//                        )
//                    }
//                }
//            }
//        }
//
//                if (searchText.isNotEmpty() && suggestions.isEmpty()) {
//            Text(
//                "No items found",
//                modifier = Modifier
//                    .padding(start = 16.dp, top = 72.dp)
//                    .fillMaxWidth()
//            )
//        }
//    }
//}

//@Composable
//fun SearchBar(
//    navController: NavController, // Add this
//    listOfItems: List<Item>,
//    placeholderText: String
//) {
//    var searchText by remember { mutableStateOf("") }
//    var showSuggestions by remember { mutableStateOf(false) }
//
//    val suggestions = if (searchText.isNotEmpty()) {
//        listOfItems.filter { it.name.contains(searchText, ignoreCase = true) }
//            .sortedBy { it.name }
//            .take(3)
//    } else {
//        emptyList()
//    }
//
//    LaunchedEffect(searchText) {
//        showSuggestions = suggestions.isNotEmpty()
//    }
//
//    Box {
//        Column {
//            TextField(
//                value = searchText,
//                onValueChange = {
//                    searchText = it
//                    showSuggestions = true
//                },
//                placeholder = { Text(placeholderText) },
//                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp, vertical = 8.dp)
//                    .background(Color.White, shape = RoundedCornerShape(8.dp))
//                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp)),
//                colors = TextFieldDefaults.textFieldColors(
//                    backgroundColor = Color.Transparent,
//                    cursorColor = Color.Black,
//                    leadingIconColor = Color.Gray,
//                    placeholderColor = Color.Gray,
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent
//                )
//            )
//
//            if (showSuggestions) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color.White)
//                        .wrapContentHeight()
//                ) {
//                    suggestions.forEach { suggestion ->
//                        Text(
//                            text = suggestion.name,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .clickable {
//                                    // Update this part to navigate to item details
//                                    navController.navigate("ItemDetails/${suggestion.id}/${suggestion.type}")
//                                    searchText = ""
//                                    showSuggestions = false
//                                }
//                                .padding(16.dp)
//                        )
//                    }
//                }
//            }
//        }
//
//        if (searchText.isNotEmpty() && suggestions.isEmpty()) {
//            Text(
//                "No items found",
//                modifier = Modifier
//                    .padding(start = 16.dp, top = 72.dp)
//                    .fillMaxWidth()
//            )
//        }
//    }
//}
//
//@Composable
//fun SearchBar(
//    listOfItems: List<Item>,
//    placeholderText: String,
//    onSuggestionSelected: (Item) -> Unit
//) {
//    var searchText by remember { mutableStateOf("") }
//    var showSuggestions by remember { mutableStateOf(false) }
//
//    // Update search logic to start from the first letter and match any substring
//    val suggestions = if (searchText.isNotEmpty()) {
//        listOfItems.filter { it.name.contains(searchText, ignoreCase = true) }
//            .sortedBy { it.name }
//            .take(3)
//    } else {
//        emptyList()
//    }
//
//    // Detect if there are suggestions to show
//    LaunchedEffect(searchText) {
//        showSuggestions = suggestions.isNotEmpty()
//    }
//
//    Box {
//        Column {
//            TextField(
//                value = searchText,
//                onValueChange = {
//                    searchText = it
//                    showSuggestions = true
//                },
//                placeholder = { Text(placeholderText) },
//                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp, vertical = 8.dp)
//                    .background(Color.White, shape = RoundedCornerShape(8.dp))
//                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp)),
//                colors = TextFieldDefaults.textFieldColors(
//                    backgroundColor = Color.Transparent,
//                    cursorColor = Color.Black,
//                    leadingIconColor = Color.Gray,
//                    placeholderColor = Color.Gray,
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent
//                )
//            )
//
//            // Floating suggestions overlay
//            if (showSuggestions) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color.White)
//                        .wrapContentHeight()
//                ) {
//                    suggestions.forEach { suggestion ->
//                        Text(
//                            text = suggestion.name,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .clickable {
//                                    onSuggestionSelected(suggestion)
//                                    searchText = ""
//                                    showSuggestions = false
//                                }
//                                .padding(16.dp)
//                        )
//                    }
//                }
//            }
//        }
//
//        if (searchText.isNotEmpty() && suggestions.isEmpty()) {
//            Text(
//                "No items found",
//                modifier = Modifier
//                    .padding(start = 16.dp, top = 72.dp) // Adjust padding as needed
//                    .fillMaxWidth()
//            )
//        }
//    }
//}
//
