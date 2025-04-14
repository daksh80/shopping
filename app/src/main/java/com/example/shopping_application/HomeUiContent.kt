package com.example.shopping_application

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping_application.ui.theme.Pink40
import com.example.shopping_application.ui.theme.pink


@Composable
fun HomeUI() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .background(pink)
                    .fillMaxWidth()
                    .height(100.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                button(icon = R.drawable.baseline_menu_24, Color.White)
                Text(
                    text = "Home",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Light
                    )
                )
                button(icon = R.drawable.baseline_search)
            }
            Card(modifier = Modifier.fillMaxWidth()) {
                LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                    items(shoppingData.shoppingItems) { item ->
                        ShowSuit(data = item)
                    }
                })
            }
        }
    }
}


@Composable
fun ShowSuit(data: shoppingData.ShoppingItem) {
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(175.dp)
            .height(250.dp)
            .padding(vertical = 7.dp, horizontal = 7.dp)
    ){
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 7.dp, horizontal = 7.dp)
                        .background(Color.White),
                        horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = data.img),
                        contentDescription = "" ,
                        modifier = Modifier
                            .size(109.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop)
                    Text(
                        text = data.price,
                        style = TextStyle(fontSize = 14.sp,
                            fontWeight = FontWeight.W700,
                            color = Color.Red),
                        textAlign = TextAlign.Center
                    )
                    Text(text = data.description,
                        style = TextStyle(fontSize = 16.sp,
                            fontWeight = FontWeight.W700,
                            color = Color.Black),
                        textAlign = TextAlign.Center
                    )
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier.width(91.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = ButtonDefaults.buttonColors(
                        containerColor = pink
                    )) {
                        Text(text = "Add",
                            style = TextStyle(fontSize = 14.sp,
                                fontWeight = FontWeight.W700,
                                color = Color.White),
                            textAlign = TextAlign.Center
                        )
                    }

                }
        }
    }
}

@Composable
fun button(
    @DrawableRes icon : Int,
    tint: Color = Color.Unspecified,
){
    IconButton(onClick = { /*TODO*/ }) {
        Icon(painter= painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.background(tint))
    }
    
}