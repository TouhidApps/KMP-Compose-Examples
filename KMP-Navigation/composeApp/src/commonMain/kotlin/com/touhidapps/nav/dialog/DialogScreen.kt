package com.touhidapps.nav.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DialogScreen(modifier: Modifier = Modifier, onClose: () -> Unit) {

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface {
            Column(
                modifier = Modifier.padding(16.dp).background(Color.LightGray)
            ) {
                Text(text = "Hello from dialog.", style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.height(15.dp))
                Button(onClick = onClose) {
                    Text("Done")
                }
            }
        }

    } // Box

} // DialogScreen

@Preview()
@Composable
fun MyDialogPreview() {
    DialogScreen {
        // Close event
    }
}