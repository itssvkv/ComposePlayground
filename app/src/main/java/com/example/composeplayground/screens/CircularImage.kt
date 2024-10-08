package com.example.composeplayground.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.R

@Composable
fun CircularImage() {
    Image(
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape),
        painter = painterResource(id = R.drawable.cr7),
        contentDescription = "cr7"
    )
}

@Preview(showBackground = true)
@Composable
private fun CircularImagePreview() {
    CircularImage()
}