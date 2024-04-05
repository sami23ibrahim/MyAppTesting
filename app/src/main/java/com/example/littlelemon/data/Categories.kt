package com.example.littlelemon.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Categories(
    val name: String,
    val imageResId: Int
)


@Composable
fun CategoryIcon(categoryName: String, imageResId: Int, categoryIsSelected: Boolean, onClick: () -> Unit) {
    Column(

        modifier = Modifier

            .padding(horizontal = 8.dp, vertical = 7.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
              //  .size(56.dp)
                .size(if (categoryIsSelected) 61.dp else 56.dp) // Larger size for selected icon

                //  .background(if (isSelected) Color(0xFFececec) else Color.White,
              .background(if (categoryIsSelected) Color.Yellow else Color.White,

                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "$categoryName icon",
                modifier = Modifier.size(62.dp)
            )
        }
        Spacer(modifier = Modifier.height(9.dp))
        Text(
            text = categoryName,
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier.background(
                Color(0xFFFFFFFF),
               // Color(0xFFececec),
                shape = RoundedCornerShape(24.dp)
            )

        )
    }
}
