package com.luanlima.musicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.media3.common.MediaItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.media3.exoplayer.ExoPlayer
import com.luanlima.musicplayer.ui.theme.MusicPlayerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val player = ExoPlayer.Builder(this).build()

        val mediaItem = MediaItem.fromUri("")

        player.setMediaItem(mediaItem)

        player.prepare()

        enableEdgeToEdge()
        setContent {
            MusicPlayerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Column {
                        MusicPlayerApp(
                            onClick = player::play,
                            modifier = Modifier
                                .padding(it)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MusicPlayerApp(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            ElevatedButton(onClick = onClick) {
                Text("Reproduzir")
            }

            ElevatedButton(onClick = onClick) {
                Text("Pausar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MusicPlayerTheme {
        Scaffold(Modifier.fillMaxSize()) {
            MusicPlayerApp(
                onClick = {},
                modifier = Modifier.padding(it)
            )
        }
    }
}