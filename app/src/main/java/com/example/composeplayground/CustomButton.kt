package com.example.composeplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.theme.Shapes


@Composable
fun CustomButton(
    basicText: String = "Login",
    basicColor: Color = MaterialTheme.colorScheme.primary,
    loadingColor: Color = MaterialTheme.colorScheme.secondary,
) {
    var clicked by remember {
        mutableStateOf(
            false
        )
    }


    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        color = if (clicked) loadingColor else basicColor,
        shape = Shapes.extraLarge,
        onClick = { clicked = !clicked }
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (clicked) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    strokeWidth = 2.dp,
                    color = Color.White
                )
            } else {
                Text(
                    text = basicText,
                    fontWeight = FontWeight.Bold,
                )
            }
        }

    }
}


@Composable
@Preview
fun CustomButtonPreview() {
    CustomButton()
}
