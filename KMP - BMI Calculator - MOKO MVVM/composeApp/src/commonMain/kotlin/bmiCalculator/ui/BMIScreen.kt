package bmiCalculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import bmiCalculator.ui.components.BMIOverlayView
import bmiCalculator.ui.components.BodyMeasurementsView
import bmiCalculator.viewModel.BMIViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun BMIScreen(viewModel: BMIViewModel) {
    val state = viewModel.uiState.collectAsState()

    BMIScreen(state.value) { event ->
        viewModel.onEvent(event)
    }
}

@Composable
fun BMIScreen(
    state: BMIViewModel.UIState,
    onEvent: (BMIViewModel.UIEvent) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            Box(
                modifier = Modifier.fillMaxWidth().height(Dp(200F)).background(state.accentColor),
                contentAlignment = Alignment.Center
            ) {
                BMIOverlayView(state.bmiDisplay)
            }

            BodyMeasurementsView(
                modifier = Modifier.fillMaxWidth().weight(0.5f),
                heightCm = state.bodyMeasurements.heightCm,
                heightDisplay = state.heightDisplay,
                weightKg = state.bodyMeasurements.weightKg,
                weightDisplay = state.weightDisplay,
                onEvent = onEvent
            )
        }


    }
}

@Preview
@Composable
fun BMIScreenPreview() {
    BMIScreen(BMIViewModel.UIState()) {

    }
}