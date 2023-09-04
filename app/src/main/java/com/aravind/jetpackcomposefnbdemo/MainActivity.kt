package com.aravind.jetpackcomposefnbdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        LazyColumn(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxSize()
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.LocationOn, contentDescription = "", tint = Color.Red)
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Home",
                            style = MaterialTheme.typography.labelLarge,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "Appartments Phase 2, Flat No 1, Sri road",
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
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                        .border(
                            border = BorderStroke(0.5.dp, Color.Gray),
                            shape = RoundedCornerShape(30)
                        ),
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
            }
            item { Spacer(modifier = Modifier.height(20.dp)) }
            item {
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(2),
                    modifier = Modifier
                        .height(160.dp)
                        .padding(start = 10.dp, end = 10.dp)
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
                            val gradient = Brush.verticalGradient(
                                0F to Color.Transparent,
                                0.5F to Color.Black.copy(alpha = 0.1F),
                                1F to Color.Black.copy(alpha = 1F)
                            )
                            Row() {
                                Box(contentAlignment = Alignment.BottomStart) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_burger),
                                        contentDescription = "Profile pic",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(80.dp)

                                    )
                                    Box(
                                        modifier = Modifier
                                            .size(80.dp)
                                            .background(gradient)
                                    ) {

                                    }
                                    Text(
                                        text = "20% OFF",
                                        style = MaterialTheme.typography.labelMedium,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis,
                                        color = Color.White,
                                        modifier = Modifier
                                            .align(Alignment.BottomStart)
                                            .padding(start = 5.dp, bottom = 5.dp)

                                    )
                                }
                                Column(
                                    modifier = Modifier.padding(
                                        start = 8.dp,
                                        end = 8.dp,
                                        top = 5.dp,
                                        bottom = 5.dp
                                    )
                                ) {
                                    Text(
                                        text = "Hotel Y",
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
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            val restaurantsList =
                listOf<String>("Hotel A", "Hotel B", "Hotel C", "Hotel D", "Hotel E", "Hotel F")
            items(restaurantsList) {
                Card(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp,

                        ),
                    modifier = Modifier.padding(bottom = 20.dp, start = 10.dp, end = 10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    )
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.ic_burger),
                            contentDescription = "Profile pic",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                        )
                        Column(modifier = Modifier.padding(start = 10.dp, bottom = 5.dp)) {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.headlineSmall,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "South Indian",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.Gray,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
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

