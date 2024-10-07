package com.example.composeplayground.old

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun CoilImage() {
    val imageUri =
        "https://i.guim.co.uk/img/media/3b2cb52d6b97bce6bf41175cdc0897a0e7da868c/0_53_2926_1755/master/2926.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=5161f0424b416d74aa641e5683c46cd3"
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUri)
            .crossfade(1000)
            .build(),
    )
    val painterState = painter.state

    Box(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        contentAlignment = Alignment.Center
    ) {

        Image(painter = painter, contentDescription = "s"
        , modifier = Modifier.clip(CircleShape))
        if (painterState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator()
        }
    }
}


@Composable
@Preview
fun CoilImagePreview() {
    CoilImage()

}