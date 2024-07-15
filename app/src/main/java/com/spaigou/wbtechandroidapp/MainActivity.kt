package com.spaigou.wbtechandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.spaigou.wbtechandroidapp.lessons.FirstLesson
import com.spaigou.wbtechandroidapp.lessons.SecondLesson
import com.spaigou.wbtechandroidapp.ui.theme.WBTechAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WBTechAndroidAppTheme {
                SecondLesson()
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