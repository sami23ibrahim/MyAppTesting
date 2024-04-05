package com.example.littlelemon

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun Add(foodName :String ){
    var count by rememberSaveable( ) { mutableStateOf(0) }
    ItemOrder(foodName,count,{count++},{ if (count > 0) count-- })
}


@Composable
fun ItemOrder(foodName: String ,count: Int, onIncrement:()-> Unit, onDecrement:()->Unit) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card() {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "$foodName",
                    fontWeight = FontWeight.W700,
                    fontSize = 30.sp
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(onClick = { if (count > 0) onDecrement() }) {
                        Text("-", fontSize = 32.sp)
                    }
                    Spacer(modifier = Modifier.width(26.dp))
                    Text(
                        text = count.toString(),
                        modifier = Modifier.size(42.dp),
                        fontSize = 32.sp
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    TextButton(onClick = {onIncrement()}) {
                        Text("+", fontSize = 32.sp)
                    }
                }
                Button(onClick= {
                    if (count > 0){
                           Toast.makeText(context,"Items Added Successfully!", Toast.LENGTH_SHORT).show()
                    }}
                    , Modifier.fillMaxWidth()) {
                    Text(text = "Add")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddPreview() {
    LittleLemonTheme {
        Add("SHAWARMA")
    }
}