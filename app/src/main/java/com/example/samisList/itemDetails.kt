package com.example.littlelemon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.data.CounterDisplay
import com.example.littlelemon.data.getItem

@Composable
fun itemDetails(id: Int, listName: String) {
//     Retrieve the Item object by its ID
//    Accesses the ShopingListItems Map: It looks up an entry in the ShopingListItems map within the
//     ShopingListManager object using id as the key. ShopingListItems is a map where each key is an
//     Int that corresponds to the ID of an item, and each value is a Pair<Item, Int>. The first
//     element of the pair (first) is the Item object, and the second element (second) is an Int
//     representing the quantity of that item in the shopping list.
//
//    Retrieves the Item's Quantity: It attempts to retrieve the second element of the pair (second)
//     associated with the given id. This second element represents the count or quantity of the
//     item in the shopping list.
    val itemCount: Int = ShopingListManager.ShopingListItems[id]?.second ?: 0
    val item = getItem(id, listName)
  if (item == null) {
        // Handle null item (show error message or default view)
        Text("Item not found")
    } else {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = item.name,
                    modifier = Modifier.size(380.dp)
        )
        Text(
            text = item.name,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = item.description,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
        // Use a Box to ensure the counter stays in place
        Box(
            modifier = Modifier.fillMaxSize()
            //    .matchParentSize()
        ) {
            // The counter or button will always be aligned to the bottom end
            if (itemCount > 0) {
                CounterDisplay(
                    x = 127, y = 150,
                    itemCount = itemCount,
                    updateItemCount = { newCount: Int ->
                        if (newCount > itemCount) {
                            ShopingListManager.addItem(item)
                        } else {
                            ShopingListManager.removeItem(item)
                        }
                    },
                    fontSize= 30.sp,
                    backgroundColor = Color.LightGray,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 58.dp, end = 8.dp)
                          .size(78.dp)
                        .background(Color.LightGray, shape = CircleShape)
                )
            }  else {
                IconButton(
                    onClick = {
                        ShopingListManager.addItem(item)
                        // Do not manually set itemCount here; it's automatically updated
                    },
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(bottom = 0.dp, end = 8.dp,top = 78.dp)
                        .size(68.dp)
                        .background(color =Color(0xFFF1F3F3), shape = CircleShape)

                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        }

    }
}}
