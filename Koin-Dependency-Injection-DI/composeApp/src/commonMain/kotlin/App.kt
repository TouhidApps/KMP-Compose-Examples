import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dependencies.DBClient
import dependencies.MyViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import koin_dependency_injection_di.composeapp.generated.resources.Res
import koin_dependency_injection_di.composeapp.generated.resources.compose_multiplatform
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
//            val dbClient = koinInject<DBClient>()

            NavHost(
                navController = rememberNavController(),
                startDestination = "home"
            ) {
                composable(route = "home") {

                    val viewModel = koinViewModel<MyViewModel>()

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = viewModel.getHelloWorldString()
                        )
                    }
                }
            }

        }
    }
}