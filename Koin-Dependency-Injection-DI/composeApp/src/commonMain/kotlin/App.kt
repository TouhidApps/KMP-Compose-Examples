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
import di.appModule
import di.platformModule
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import koin_dependency_injection_di.composeapp.generated.resources.Res
import koin_dependency_injection_di.composeapp.generated.resources.compose_multiplatform
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {

    /**
     * By using KoinApplication inside compose App,
     * we don't need to declear startKoin so code is less
     */
    KoinApplication(application = {
        modules(appModule, platformModule)
    }) {
        MaterialTheme {

            // Mark
            // remember is inside of koinInject so no need to use remember
            val greeter: Greeter = koinInject<Greeter>()

            var showContent by remember { mutableStateOf(false) }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = { showContent = !showContent }) {
                    Text("Click me!")
                }
                AnimatedVisibility(showContent) {

                    // Mark
                    val greeting = remember { greeter.greet() } // New code
//                    val greeting = remember { Greeting().greet() } // Old code

                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painterResource(Res.drawable.compose_multiplatform), null)
                        Text("Compose: $greeting")
                    }
                }
            }

        }
    } // KoinApplication


}