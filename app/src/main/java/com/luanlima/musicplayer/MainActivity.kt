package com.luanlima.musicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.luanlima.musicplayer.ui.theme.MusicPlayerTheme
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.ui.Alignment
import androidx.media3.exoplayer.ExoPlayer


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val player = ExoPlayer.Builder(this).build()

        enableEdgeToEdge()
        setContent {
            MusicPlayerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Greeting(
                        onClick = player::play,
                        modifier = Modifier
                            .padding(it)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedButton(onClick = onClick) {
            Text("Reproduzir")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MusicPlayerTheme {
        Scaffold(Modifier.fillMaxSize()) {
            Greeting(
                onClick = {},
                modifier = Modifier.padding(it)
            )
        }
    }
}