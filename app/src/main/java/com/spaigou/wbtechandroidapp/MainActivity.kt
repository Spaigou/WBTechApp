package com.spaigou.wbtechandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.spaigou.wbtechandroidapp.lessons.FirstLesson
import com.spaigou.wbtechandroidapp.lessons.SecondLesson
import com.spaigou.wbtechandroidapp.navigation.AppNavGraph
import com.spaigou.wbtechandroidapp.ui.theme.WBTechAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WBTechAndroidAppTheme {
                AppNavGraph(navController = rememberNavController())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondLessonPreview() {
    WBTechAndroidAppTheme {
        SecondLesson()
    }
}