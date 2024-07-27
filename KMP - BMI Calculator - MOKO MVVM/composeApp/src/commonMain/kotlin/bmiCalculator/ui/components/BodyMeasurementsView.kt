package bmiCalculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bmiCalculator.viewModel.BMIViewModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BodyMeasurementsView(
    modifier: Modifier = Modifier,
    heightCm: Float,
    heightDisplay: String,
    weightKg: Float,
    weightDisplay: String,
    onEvent: (BMIViewModel.UIEvent) -> Unit
) {

    Column(
        modifier = modifier.background(Color.White).padding(all = 32.dp).padding(top = 100.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Height", color = Color.Black, fontSize = 12.sp)
            Text(text = heightDisplay, color = Color.Black, fontSize = 12.sp)
        }

        SliderView(min = 120f, max = 210f, steps = 90, sliderPosition = heightCm) { height ->
            onEvent(BMIViewModel.UIEvent.ChangeHeight(height))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Weight", color = Color.Black, fontSize = 12.sp)
            Text(text = weightDisplay, color = Color.Black, fontSize = 12.sp)
        }

        SliderView(min = 30f, max = 150f, steps = 240, sliderPosition = weightKg) { weight ->
            onEvent(BMIViewModel.UIEvent.ChangeWeight(weight))
        }
    }

}


@Preview
@Composable
fun BodyMeasurementsViewPreview() {
    BodyMeasurementsView(
        modifier = Modifier.fillMaxWidth(),
        heightCm = 173f,
        heightDisplay = "173",
        weightKg = 75f,
        weightDisplay = "75",
    ) {

    }
}