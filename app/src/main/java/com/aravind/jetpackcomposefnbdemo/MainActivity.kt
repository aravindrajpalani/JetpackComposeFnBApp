package com.aravind.jetpackcomposefnbdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.aravind.jetpackcomposefnbdemo.ui.theme.JetpackComposeFnBDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeFnBDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeFnBDemoTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 0.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.LocationOn, contentDescription = "", tint = Color.Red)
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Home", style = MaterialTheme.typography.labelLarge, maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "DABC Gokulam Phase 2, Flat No 1, Sriram Nagar main road",
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_letter_a),
                contentDescription = "Profile pic",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(border = BorderStroke(0.5.dp, Color.Gray), shape = RoundedCornerShape(30)),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                tint = Color.Red,
                modifier = Modifier.padding(start = 5.dp)
            )
            Text(
                text = "Search",
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = 2.dp, top = 10.dp, bottom = 10.dp)
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            modifier = Modifier
                .weight(weight = 1f, fill = false)
                .height(160.dp)
        ) {
            items(20) { photo ->
                val paddingModifier = Modifier.padding(end = 10.dp, bottom = 10.dp)
                Card(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp,

                        ), modifier = paddingModifier, colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    )
                ) {
                    Row() {
                        Image(
                            painter = painterResource(id = R.drawable.ic_burger),
                            contentDescription = "Profile pic",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(80.dp)
                        )
                        Column(
                            modifier = Modifier.padding(
                                start = 8.dp,
                                end = 8.dp,
                                top = 5.dp,
                                bottom = 5.dp
                            )
                        ) {
                            Text(
                                text = "Hotel Yamuna",
                                style = MaterialTheme.typography.labelMedium,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,

                                )
                            Text(
                                text = "South Indian",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.Gray,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.weight(1f)
                            )
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painterResource(id = R.drawable.ic_schedule_black),
                                    contentDescription = "",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .size(12.dp)
                                        .align(Alignment.CenterVertically)
                                )
                                Spacer(modifier = Modifier.width(2.dp))
                                Text(
                                    text = "30 - 35 min",
                                    color = Color.Gray,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    fontSize = 10.sp
                                    )
                            }
                        }
                    }
                }
            }
        }
    }

}