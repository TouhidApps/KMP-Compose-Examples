import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import bmiCalculator.ui.BMIScreen
import bmiCalculator.viewModel.BMIViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import bmicalculator.composeapp.generated.resources.Res
import bmicalculator.composeapp.generated.resources.compose_multiplatform
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
@Preview
fun App() {
    MaterialTheme {

        val viewModel = getViewModel(
            key = "bmi-screen",
            factory = viewModelFactory {
                BMIViewModel()
            }
        ) // getViewModel

        BMIScreen(viewModel)

    }
}