package com.example.littlelemon
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.data.CounterDisplay
import com.example.littlelemon.data.Item


object ShopingListManager {
    val ShopingListItems = mutableStateMapOf<Int, Pair<Item, Int>>()
    val checkedStateMap = mutableStateMapOf<Int, Boolean>()

    fun addItem(item: Item) {
        val currentCount = ShopingListItems[item.id]?.second ?: 0
        ShopingListItems[item.id] = Pair(item, currentCount + 1)
    }

    fun removeItem(item: Item) {
        val currentCount = ShopingListItems[item.id]?.second ?: return
        if (currentCount > 1) {
            ShopingListItems[item.id] = Pair(item, currentCount - 1)
        } else {
            ShopingListItems.remove(item.id)
            setChecked(item.id, false) // Uncheck the item when removed
        }
    }

    fun getItemCount(item: Item): Int {
        return ShopingListItems[item.id]?.second ?: 0
    }

    fun isChecked(itemId: Int): Boolean {
        return checkedStateMap[itemId] ?: false // Default to false if not present
    }

    fun setChecked(itemId: Int, isChecked: Boolean) {
        checkedStateMap[itemId] = isChecked
    }
}
//************************

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShoppingCartDisplay(shoppingListItems: MutableMap<Int, Pair<Item, Int>>) {
    val itemsByAisle = shoppingListItems.values.groupBy { it.first.aisle }
    val totalPrice = remember { mutableStateOf(0.0) }

    // Update the total when the composable recomposes
    totalPrice.value = shoppingListItems.entries.sumOf { (id, pair) ->
        val (item, quantity) = pair
        if (ShopingListManager.isChecked(id)) {
            item.price * quantity
        } else {
            0.0
        }
    }


        Image(
            painter = painterResource(id = R.drawable.screen),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {



        item {

                Text(
                    text = "My Shopping List",
                    fontSize = 36.sp,
                    color =Color(0xFF464949),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 32.dp, bottom = 6.dp, top = 5.dp)
                )

        }

            itemsByAisle.forEach { (aisleNumber, itemsInAisle) ->
                item {
                    Text(
                        color = Color(0xFF515353),
                        text = "Aisle $aisleNumber",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 0.dp, bottom = 8.dp, top = 16.dp)

                    )
                }

                items(itemsInAisle) { (item, quantity) ->
                    val itemId = shoppingListItems.entries.first { it.value.first == item }.key
                    val isChecked =
                        remember { mutableStateOf(ShopingListManager.isChecked(itemId)) }

                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        modifier = Modifier
                            .padding(vertical = 4.dp, horizontal = 8.dp)
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(all = 4.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = isChecked.value,
                                onCheckedChange = { checked ->
                                    isChecked.value = checked
                                    ShopingListManager.setChecked(itemId, checked)
                                    if (checked) {
                                        totalPrice.value += item.price * quantity
                                    } else {
                                        totalPrice.value -= item.price * quantity
                                    }
                                },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color(0xFF009688),
                                    uncheckedColor = Color.White
                                ),
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(start = 20.dp, end = 18.dp)
                                    .scale(1.8f)
                            )
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 4.dp)
                            ) {
                                Text(
                                    text = item.name,

                                    modifier = Modifier.padding(
                                        start = 22.dp,
                                        bottom = 6.dp,
                                        top = 5.dp
                                    ),
                                    fontSize = 20.sp,
                                    color = Color(0xFF000000),
                                    // color =Color.White,
                                    fontWeight = FontWeight.Bold

                                )
                                val itemTotalPrice = item.price * quantity
                                Text(
                                    text = "Total: $${"%.2f".format(itemTotalPrice)}",
                                    modifier = Modifier.padding(
                                        start = 22.dp,
                                        bottom = 6.dp,
                                        top = 5.dp
                                    ),
                                    fontSize = 18.sp,
                                    color = Color.Red,
                                    fontWeight = FontWeight.Medium
                                )
                            }

                            CounterDisplay(
                                y = -1, x = -5,
                                itemCount = quantity,
                                updateItemCount = { newCount ->
                                    if (newCount > 0) {
                                        val difference = newCount - quantity
                                        shoppingListItems[itemId] = item to newCount
                                        if (isChecked.value) {
                                            totalPrice.value += difference * item.price
                                        }
                                    } else {
                                        shoppingListItems.remove(itemId)
                                        if (isChecked.value) {
                                            totalPrice.value -= item.price * quantity
                                        }
                                        ShopingListManager.setChecked(itemId, false)
                                    }
                                }
                            )

                        }
                    }
                }

            }

            // This is the additional padding at the bottom to ensure the total amount is visible.
            item {
                Spacer(modifier = Modifier.height(30.dp))
            }
            item {  Text(
                text = "Total Amount: $${"%.2f".format(totalPrice.value)}",
                fontSize = 29.sp,
                color =Color(0xFF009688),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 54.dp, top = 6.dp)
                //   .background(color = Color(0xFFF0EEF1), shape = RoundedCornerShape(16.dp))
            )}
            item {
                Spacer(modifier = Modifier.height(60.dp))
            }
        }


}