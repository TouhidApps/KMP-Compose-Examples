package com.touhidapps.nav.drawerMenu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NavigationDrawerContent(
    modifier: Modifier = Modifier,
    onClose: () -> Unit
) {

    ModalDrawerSheet {
        Column(
            modifier = modifier.fillMaxHeight().padding(16.dp)
        ) {
            NavigationDrawerItem(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Close") },
                selected = false,
                onClick = onClose,
                icon = { Icon(Icons.Filled.Close, contentDescription = "Close drawer") }
            )
        }
    }

}