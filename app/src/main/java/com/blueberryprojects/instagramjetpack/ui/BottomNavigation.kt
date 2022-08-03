package com.blueberryprojects.instagramjetpack.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blueberryprojects.instagramjetpack.NavigationItem
import com.blueberryprojects.instagramjetpack.R

@Composable
fun BottomNavigation() {
    val navigationItems = listOf(
        NavigationItem(painterResource(id = R.drawable.ic_baseline_home_24)),
        NavigationItem(painterResource(id = R.drawable.ic_baseline_search_24)),
        NavigationItem(painterResource(id = R.drawable.ic_reel)),
        NavigationItem(painterResource(id = R.drawable.ic_heart)),
        NavigationItem(painterResource(id = R.drawable.ic_me))
    )

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth(),
    ) {

        navigationItems.forEachIndexed { index, item ->
            BottomNavigationItem(index = index, icon = item.icon)
        }
    }
}

@Composable
fun BottomNavigationItem(
    index: Int,
    icon: Painter,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (index == 4) {
            Image(painter = icon,
                modifier = Modifier
                    .size(24.dp)
                    .border(1.dp, Color.Black, shape = CircleShape)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                contentDescription = null)
        } else {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(if (index == 2 || index == 3) {
                        22.dp
                    } else {
                        26.dp
                    })
            )
        }
        Text(text = "•",
            fontSize = 16.sp,
            color = Color.Red,
            modifier = Modifier
                .offset(y = (-6).dp)
                .alpha(if (index == 4) {
                    1f
                } else {
                    0f
                }))
    }
}