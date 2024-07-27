package bmiCalculator.utils

import androidx.compose.ui.graphics.Color
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.roundToInt

fun Float.roundUpToNearestInteger(): Int = (this + 0.5f).toInt()

fun Float.roundToNearestHalf(): Float = (this * 2f).roundToInt() / 2.0f

fun Float.toFormattedString(decimals: Int = 2): String {
    val multiplier = 10.toFloat().pow(decimals)
    val rounded = round(this * multiplier) / multiplier
    return rounded.toString()
}

fun Float.toBMIColor(): Color {
    if (this < 18.5f) { // Underweight
        return Color(0xFF00CEE6)
    } else if (this < 25.0f) { // Normal Weight
        return Color(0xFF96CD3E)
    } else if (this < 30.0f) { // Overweight
        return Color(0xFFF4BD40)
    } else if (this < 35.0f) { // Obesity (Class I)
        return Color(0xFFEE7D29)
    } else if (this < 40.0f) { // Obesity (Class II)
        return Color(0xFFED5321)
    }
    return Color(0xFFED5321) // Obesity (Class III)
}