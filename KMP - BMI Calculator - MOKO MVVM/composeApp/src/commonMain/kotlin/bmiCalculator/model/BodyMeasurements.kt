package bmiCalculator.model

data class BodyMeasurements (
    val heightCm: Float,
    val weightKg: Float
) {
    fun toBMI(): Float {
        return this.weightKg / (this.heightCm * this.heightCm * 0.0001f)
    }
}

