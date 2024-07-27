import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kmpresourcesharing.composeapp.generated.resources.Res
import kmpresourcesharing.composeapp.generated.resources.compose_multiplatform
import kmpresourcesharing.composeapp.generated.resources.hello_world
import kmpresourcesharing.composeapp.generated.resources.ic_android_black_24dp
import org.jetbrains.compose.resources.stringResource

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

                    Image(painterResource(Res.drawable.ic_android_black_24dp), null)

                    Text("Compose: $greeting")
                    Text(
                        text = stringResource(Res.string.hello_world)
                    )
                }
            }
        }
    }
}

