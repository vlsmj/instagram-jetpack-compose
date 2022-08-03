package com.blueberryprojects.instagramjetpack.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.blueberryprojects.instagramjetpack.NavigationItem
import com.blueberryprojects.instagramjetpack.R
import com.blueberryprojects.instagramjetpack.Statistic
import com.blueberryprojects.instagramjetpack.User

@Composable
fun ProfileScreen(username: String) {
    var selectedTab by remember {
        mutableStateOf(0)
    }

    TopBar(username = username)

    StatisticSection(
        statistics = listOf(
            Statistic("640", "Posts"),
            Statistic("27.3M", "Followers"),
            Statistic("111", "Following")),
        profileImage = R.drawable.iu_profile
    )

    ProfileDescription(
        profileName = "이지금 IU",
        description = "strawberrymoon❤️❤️\uD83C\uDF53❤️❤️\n",
        url = "youtu.be/sqgxcCjD04s"
    )

    FollowedBySection(
        users = listOf(
            User(R.drawable.yang_bobier, "yangbobier"),
            User(R.drawable.kim_ji_won, "geewonii"),
            User(R.drawable.kim_tae_ri, "kimtaeri_official"),
            User(0, "testdata"),
            User(0, "testdata"))
    )

    ActionSection(modifier = Modifier
        .padding(start = 16.dp, top = 5.dp, end = 16.dp)
        .fillMaxWidth())

    TabNavigation(modifier = Modifier
        .padding(top = 8.dp)
        .fillMaxWidth(),
        tabs = listOf(
            NavigationItem(painterResource(id = R.drawable.ic_baseline_grid_on_24)),
            NavigationItem(painterResource(id = R.drawable.ic_reel)),
            NavigationItem(painterResource(id = R.drawable.ic_tagged)))) {
        selectedTab = it
    }

    if (selectedTab == 0) {
        Posts(
            images = listOf(
                painterResource(id = R.drawable.iu_post_1),
                painterResource(id = R.drawable.iu_post_2),
                painterResource(id = R.drawable.iu_post_3),
                painterResource(id = R.drawable.iu_post_4),
                painterResource(id = R.drawable.iu_post_5),
                painterResource(id = R.drawable.iu_post_6),
                painterResource(id = R.drawable.iu_post_7),
                painterResource(id = R.drawable.iu_post_8),
                painterResource(id = R.drawable.iu_post_9),
                painterResource(id = R.drawable.iu_post_10),
                painterResource(id = R.drawable.iu_post_11),
                painterResource(id = R.drawable.iu_post_12),
            )
        )
    }
}

@Composable
fun TopBar(username: String) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 4.dp, top = 24.dp, end = 12.dp, bottom = 8.dp)) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_new_24),
            contentDescription = "Arrow Back",
            modifier = Modifier
                .size(22.dp)
                .align(Alignment.CenterStart)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = username,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.width(4.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_verified),
                contentDescription = "Verified",
                modifier = Modifier
                    .size(13.dp)
                    .padding(top = 2.dp))
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.CenterEnd)) {
            Image(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notification",
                modifier = Modifier
                    .size(21.dp)
            )
            Spacer(modifier = Modifier.width(18.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_more_horiz_24),
                contentDescription = "More",
                modifier = Modifier
                    .size(22.dp)
            )
        }
    }
}

@Composable
fun StatisticSection(
    statistics: List<Statistic>,
    profileImage: Int,
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp)) {
        RoundImage(modifier = Modifier
            .aspectRatio(1f)
            .clip(CircleShape)
            .weight(2.1f),
            painterResource(id = profileImage), "Profile")
        Spacer(Modifier.weight(0.9f))
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(7f)) {
            statistics.forEachIndexed { _, statistic ->
                Statistic(statistic)
            }
        }
    }
}

@Composable
fun RoundImage(
    modifier: Modifier = Modifier,
    image: Painter,
    contentDescription: String?,
) {
    Image(
        painter = image,
        contentDescription = contentDescription,
        modifier = modifier
    )
}

@Composable
fun Statistic(statistic: Statistic) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        statistic.run {
            Text(text = count,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp)
            Text(text = title,
                fontSize = 12.sp)
        }
    }
}

@Composable
fun ProfileDescription(
    profileName: String,
    description: String,
    url: String,
) {
    Text(text = profileName,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        modifier = Modifier
            .padding(start = 16.dp, top = 8.dp, end = 16.dp)
            .fillMaxWidth())

    Text(text = buildAnnotatedString {
        val urlStyle = SpanStyle(
            color = Color(0xFF3D3D91),
        )
        append(description)
        pushStyle(urlStyle)
        append(url)
        pop()
    }, lineHeight = 14.sp,
        fontSize = 12.sp,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth())
}

@Composable
fun FollowedBySection(
    users: List<User>,
) {
    if (users.isNotEmpty()) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()) {
            Box(modifier = Modifier
                .padding(start = 16.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)) {
                users.forEachIndexed { index, user ->
                    if (index < 3) {
                        RoundImage(modifier = Modifier
                            .padding(start = (16.dp).times(index))
                            .zIndex((3 - index).toFloat())
                            .size(27.dp)
                            .border(1.dp, Color.White, CircleShape)
                            .clip(CircleShape),
                            painterResource(id = user.image), user.username)
                    }
                }
            }
            Text(text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                append("Followed by ")
                pushStyle(boldStyle)
                append(users[0].username)

                if (users.count() > 1) {
                    pop()
                    append(", ")
                    pushStyle(boldStyle)
                    append(users[1].username)
                }

                if (users.count() > 2) {
                    pop()
                    append(" and ")
                    pushStyle(boldStyle)
                    append("${users.count() - 2} others")
                }
            }, fontSize = 13.sp)
        }
    }
}

@Composable
fun ActionSection(
    modifier: Modifier = Modifier,
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = modifier) {
        ActionButton(modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFEFEFEF))
            .padding(8.dp)
            .weight(4.1f),
            "Following",
            painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24))
        ActionButton(modifier = Modifier
            .padding(horizontal = 6.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFEFEFEF))
            .padding(8.dp)
            .weight(4.1f),
            "Message")
        ActionButton(modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFEFEFEF))
            .padding(8.dp)
            .weight(0.8f)
            .graphicsLayer {
                rotationY = 180f
            },
            icon = painterResource(id = R.drawable.ic_baseline_person_add_alt_24))
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: Painter? = null,
) {
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier) {
        text?.let {
            Text(text = it,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp)
        }
        icon?.let {
            Icon(
                painter = icon,
                contentDescription = text ?: "",
                modifier = Modifier
                    .size(16.dp)
            )
        }
    }
}

@Composable
fun TabNavigation(
    modifier: Modifier = Modifier,
    tabs: List<NavigationItem>,
    onTabIndexChanged: (Int) -> Unit,
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)

    TabRow(selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier) {
        tabs.forEachIndexed { index, tab ->
            val isSelected = index == selectedTabIndex

            Tab(selected = isSelected,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabIndexChanged(selectedTabIndex)
                }) {
                Icon(
                    painter = tabs[index].icon,
                    contentDescription = null,
                    tint = if (isSelected) {
                        Color.Black
                    } else {
                        inactiveColor
                    },
                    modifier = Modifier
                        .padding(12.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Posts(
    images: List<Painter>,
) {
    LazyVerticalGrid(cells = GridCells.Fixed(3),
        modifier = Modifier
            .padding(bottom = 64.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(1.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp)) {
        items(images.size) {
            Box {
                Image(
                    painter = images[it],
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .aspectRatio(1f)
                )
            }
        }
    }
}












