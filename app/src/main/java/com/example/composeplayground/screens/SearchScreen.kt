package com.example.composeplayground.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.annotation.ColorRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Scaffold
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeplayground.utils.AnimatedShimmer
import com.example.composeplayground.utils.SearchWidgetState
import okhttp3.internal.wait

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel
) {
    val searchWidgetState by searchViewModel.searchWidgetState
    val searchTextState by searchViewModel.searchTextState


    Scaffold(
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState,
                searchTextString = searchTextState,
                onTextChange = {
                    searchViewModel.updateSearchTextState(newValue = it)
                },
                onCloseClicked = {
                    searchViewModel.updateSearchTextState(newValue = "")
                    searchViewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
                },
                onSearchClicked = {
                    Log.d("TAG", "SearchScreen: $it")
                },
                onSearchTriggered = {
                    searchViewModel.updateSearchWidgetState(SearchWidgetState.OPENED)
                }
            )
        }
    ) {}
}

@Composable
fun MainAppBar(
    searchWidgetState: SearchWidgetState,
    searchTextString: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
    onSearchTriggered: () -> Unit

) {
    when (searchWidgetState) {
        SearchWidgetState.CLOSED -> {
            DefaultAppBar(
                onSearchClicked = onSearchTriggered
            )
        }

        SearchWidgetState.OPENED -> {
            SearchAppBar(
                text = searchTextString,
                onTextChange = onTextChange,
                onCloseClicked = onCloseClicked,
                onSearchClicked = onSearchClicked
            )
        }
    }
}

@Composable
fun DefaultAppBar(onSearchClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Home")
        },
        actions = {
            IconButton(
                onClick = { onSearchClicked() }
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {
    Column {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            tonalElevation = AppBarDefaults.TopAppBarElevation,
            shadowElevation = AppBarDefaults.TopAppBarElevation,
            color = MaterialTheme.colorScheme.primary
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = { updatedValue ->
                    onTextChange(updatedValue)
                },
                placeholder = {
                    Text(
                        modifier = Modifier.alpha(ContentAlpha.medium),
                        text = "Search here....",
                        color = Color.White
                    )
                },
                textStyle = TextStyle(
                    fontSize = MaterialTheme.typography.titleSmall.fontSize
                ),
                singleLine = true,
                leadingIcon = {
                    IconButton(modifier = Modifier.alpha(ContentAlpha.medium),
                        onClick = {}
                    )
                    {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon",
                            tint = Color.White
                        )

                    }
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            if (text.isNotEmpty()) {
                                onTextChange("")
                            } else {
                                onCloseClicked()
                            }
                        }
                    )
                    {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close Icon",
                            tint = Color.White
                        )

                    }
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onSearchClicked(text)
                    }
                )

            )


        }

        Spacer(modifier = Modifier.height(10.dp))
        Column {
            repeat(7) {
                AnimatedShimmer()
            }

        }
    }
}

@Composable
@Preview(showBackground = false)
fun SearchScreenPreview() {
    DefaultAppBar(onSearchClicked = {

    })
}

@Preview(showBackground = true)
@Composable
private fun SearchAppBarPreview() {
    SearchAppBar(text = "gggg", onTextChange = {}, onCloseClicked = {}) {

    }
}