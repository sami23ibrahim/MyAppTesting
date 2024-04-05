package com.example.littlelemon

import androidx.compose.Composable
import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController



@androidx.compose.runtime.Composable
@Composable
fun MyBottonNavigation(navController: NavController){
    val destinationList = listOf<Destination>(
        Home,
        MenuList
    )
    val selectedIndex = rememberSaveable { mutableStateOf(0)
        /*
         A state that holds the index of the currently selected navigation item.
         It's initialized to 0 (first item in the list "Home" ).
         */
    }
        BottomNavigation {
          // destinationList.forEachIndexed, iterates over each Destination in destinationList
            destinationList.forEachIndexed {index, destination ->
                /*
                The forEachIndexed method provides two variables in the lambda (anonymous function):
                 index, which is the index of the current item in the list, and destination, which
                the actual Destination object located at that position in the list.
                //"destination" => the position of the Destination object within the destinationList
                                   in terms of its index or order in the list.
                 */
                BottomNavigationItem(
//For each Destination, a BottomNavigationItem is created.
                    modifier = Modifier.background(Color(0xFFFFFFFF)),
                    label = { Text(text = destination.title)},
                  //  label: Displays the title of the destination.
                    selected = index== selectedIndex.value,
                  //selected: A boolean indicating whether this item is currently selected.
                    icon = { Icon(imageVector= destination.icon,contentDescription = destination.title)},

                  //icon: Displays the icon associated with the destination
                    onClick = {
                        selectedIndex.value = index
                        navController.navigate(destination.route) {
                            popUpTo(Home.route) {
                                saveState = true
                            }
                            launchSingleTop = true
                        }
                        selectedIndex.value=index
                        //onClick: The logic to execute when an item is clicked. It updates the selectedIndex and
                        // uses navController.navigate to navigate to the corresponding destination.
                    navController.navigate(destinationList[index].route){
                        popUpTo(Home.route)// to remove everything from stack till homescreen
                        launchSingleTop= true//to prevent adding the same screen more that once
                    }
                    },
                            selectedContentColor = Color.Red, // Change to your preferred color when selected
                    unselectedContentColor = Color.Black // Change to your preferred color when unselected
                )
            }
        }
   }

/*
The BottomNavigationItem within your BottomNavigation composable function is called once for each item in
your destinationList during the initial composition. This means if your list has two destinations (Home and MenuList)
, BottomNavigationItem is invoked twice to create two items in the BottomNavigation.

When you click on a BottomNavigationItem, the onClick lambda is executed, but it does not recreate the entire
BottomNavigation. Instead, the click event updates the state (like selectedIndex) and/or performs navigation actions.
 The Compose framework then efficiently updates the UI based on the state changes without recreating the entire
 BottomNavigation. This approach is part of Compose's reactive pattern, where UI elements are automatically
 updated in response to state changes.
 */


