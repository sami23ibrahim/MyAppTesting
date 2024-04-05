package com.example.littlelemon

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.data.Item
import com.example.littlelemon.ui.theme.LittleLemonTheme
@Composable//onDishClick: (Int) -> Unit)
fun SectionCard(dishes: List<Item>, backgroundColor: Color = Color.LightGray){
    Column {
        dishes.forEach { dish ->
            Card(
          //      align(Alignment.End),
                modifier = Modifier.padding(
                        start = 29.dp,
                top = 0.dp,
                end = 0.dp,
                bottom = 0.dp
            )
                    .width(357.dp)

                   // .clickable { onDishClick(dish.id) }
                    .aspectRatio(0.8f / 0.4f) // width to height ratio
                   // .fillMaxWidth()
            ) {
                Column(modifier = Modifier.background(Color.White)) {
                    // Image taking up full width and 70% of height
                    Image(
                        painter = painterResource(id = dish.image),
                        contentDescription = "Dish Image",
                        modifier = Modifier.shadow(elevation = 7.dp, shape = RoundedCornerShape(12.dp))
                            .fillMaxWidth().clip(RoundedCornerShape(12.dp))
                            .weight(0.9f), // 70% of the card's height
                        contentScale = ContentScale.Crop // Adjust the scaling of the image
                    )
                    // Dish name below the image
                    Text(
                        text = dish.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun WeeklySpecialCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        // elevation = 4.dp // Adjust elevation as needed


    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
        ) {
            Text(
                text = "Weekly Specials!!",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
                    .align(Alignment.Center) // Aligns the Text widget to the end of the Box
                ,
                color= Color.Red,
                textAlign = TextAlign.End
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Helpers() {
    val context = LocalContext.current
    val counter = remember { mutableStateOf(0) }
    val normalClicks = remember { mutableStateOf(0) }
    val longClicks = remember { mutableStateOf(0) }
    Column (

        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0XFF495E57)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ){
        Button(
            onClick = {
                Toast.makeText(context,"Order successful!", Toast.LENGTH_SHORT).show()
            }
            ,modifier = Modifier.padding(horizontal = 20.dp)
            ,shape= RoundedCornerShape(20.dp)
            ,colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFF4CE14))

        )
        {
            Text(
                text = stringResource(R.string.order),
                color = Color.Black
            )
        }

        //*********************************************
        Button(
            onClick = {}
            ,modifier = Modifier.padding(horizontal = 20.dp)
            ,shape= RoundedCornerShape(20.dp)
            ,colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFF4CE14))

        )
        {
            Text(text = "Clicks: " + counter.value.toString(),
                modifier = Modifier.clickable { counter.value += 1 })
        }
//*********************************************
        Button(
            onClick = {}
            ,modifier = Modifier.padding(horizontal = 20.dp)
            ,shape= RoundedCornerShape(20.dp)
            ,colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFF4CE14))

        )
        {
            Text(
                text = "Normal: ${normalClicks.value} Long: ${longClicks.value}",
                modifier = Modifier.combinedClickable(
                    onClick = { normalClicks.value += 1 },
                    onLongClick = { longClicks.value += 1 }
                )
            )
        }



    }
}

@Preview(showBackground = true)
@Composable
fun HelpersPreview() {
    Helpers()
}
//**///**//**//**//**//**//**//**//**//**//**///**//**//**//**//**//**//**//**//**










//**///**//**//**//**//**//**//**//**//**//**///**//**//**//**//**//**//**//**//**
@Composable
fun boxy() {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFF495E57)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        val state = rememberDraggableState { delta ->
            // Handle the drag here. 'delta' is the change in pixels during the drag.
            Log.d("Box", "Delta: $delta")
        }

        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .width(70.dp)
                .height(70.dp)
                .background(Color.Gray)
                .draggable(
                    state = state,
                    orientation = Orientation.Horizontal,
                    onDragStarted = { Log.d("Box", "Starting Drag") },
                    onDragStopped = { Log.d("Box", "Finishing Drag") }
                )
        ) {
            // Content of the Box
            Text(text = "Drag me", color = Color.White,
                modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun boxyPreview() {
    LittleLemonTheme {
        boxy()
    }

}