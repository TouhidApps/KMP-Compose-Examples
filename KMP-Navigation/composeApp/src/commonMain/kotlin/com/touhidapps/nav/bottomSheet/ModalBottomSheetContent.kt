package com.touhidapps.nav.bottomSheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ModalBottomSheetContent(onClose: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxWidth().padding(15.dp)
    ) {

        Text(text = "This is a bottom sheet!", modifier = Modifier.fillMaxWidth().height(200.dp).background(Color.Cyan), textAlign = TextAlign.Center)

        Button(onClick = onClose) {
            Text(text = "Close")
        }

        Spacer(
            modifier = Modifier.height(30.dp)
        )

    }

}