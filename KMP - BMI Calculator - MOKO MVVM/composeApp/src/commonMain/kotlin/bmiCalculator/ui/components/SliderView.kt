package bmiCalculator.ui.components

import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SliderView(
    min: Float,
    max: Float,
    steps: Int,
    sliderPosition: Float,
    onPositionUpdate: (Float) -> Unit,
) {
    Slider(
        value = sliderPosition,
        valueRange = min..max,
        steps = steps,
        colors = SliderDefaults.colors(
            thumbColor = Color.Red,
            activeTrackColor = Color.Blue,
        ),
        onValueChange = { it ->
            onPositionUpdate(it)
        }
    )
}

@Preview
@Composable
fun SliderViewPreview() {
    SliderView(
        min = 0f,
        max = 100f,
        steps = 10,
        sliderPosition = 50f
    ) {

    }
}