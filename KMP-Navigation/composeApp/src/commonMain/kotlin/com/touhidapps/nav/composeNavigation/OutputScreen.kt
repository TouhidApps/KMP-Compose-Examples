package com.touhidapps.nav.composeNavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun OutputScreen(
    modifier: Modifier = Modifier,
    name: String,
    onClick: () -> Unit
) {

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = "Hello, $name")

        Button(
            onClick = onClick,
            modifier = Modifier.align(Alignment.End)
        ){
            Text(text = "Go Back")
        }
    }

}

@Preview
@Composable
fun OutputScreenView() {
    OutputScreen(
        name = "Test"
    ) {

    }
}