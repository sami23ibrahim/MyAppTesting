package com.example.littlelemon

import androidx.compose.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



//@androidx.compose.runtime.Composable
//@Composable
//fun MenuGrid () {
//    Column (Modifier.verticalScroll(rememberScrollState())
//    )
//    {
//        repeat(10){
//
//        Row (Modifier.fillMaxWidth(),
//             horizontalArrangement = Arrangement.SpaceEvenly
//        )
//
//        {
//            repeat(2){
//            GridCell ()
//            }
//        }
//}
//    }
//
//}

@androidx.compose.runtime.Composable
@Composable
fun LazyGridMenu (){
    LazyVerticalGrid(columns =GridCells.Adaptive(135.dp)){
       //Adaptive(200.dp) it means that each cell in the grid will try to have at least 200dp of width
       items(50) {number ->
           GridCell(number)

       }
    }
}




@androidx.compose.runtime.Composable
@Composable
fun GridCell (number:Int){
    Card(elevation = 20.dp,
        modifier = Modifier.padding(8.dp))
    {
        Box(modifier = Modifier
            .aspectRatio(1f)
           // .requiredSize(180.dp, 180.dp)
            .padding(8.dp))
        {
            Image(
                painter = painterResource(id = R.drawable.img666),
                contentDescription = "salad",
                
            )
            Text(text = "Greek Salad $number",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                            .background(Color.White)
                            .align(Alignment.TopStart)
            )
            Text(text = "$12.99",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 4.dp, end = 4.dp)
                    .background(Color.White)
                    .align(Alignment.BottomEnd))
        }
    }
 }

@Preview(showBackground = true)
@androidx.compose.runtime.Composable
fun MenuGridPreview () {
 //   GridCell ()
}