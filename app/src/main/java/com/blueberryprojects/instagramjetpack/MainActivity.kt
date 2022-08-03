package com.blueberryprojects.instagramjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.blueberryprojects.instagramjetpack.ui.BottomNavigation
import com.blueberryprojects.instagramjetpack.ui.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                Column {
                    ProfileScreen("dlwlrma")
                }
                Box(contentAlignment = Alignment.BottomCenter) {
                    BottomNavigation()
                }
            }
        }
    }
}