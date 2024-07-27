This is a Kotlin Multiplatform project targeting Android & iOS

### MOKO Library for MVVM (Android, iOS):

```
mvvmCompose = "0.16.1"

mvvm-compose = { module = "dev.icerock.moko:mvvm-compose", version.ref = "mvvmCompose" }

implementation(libs.mvvm.compose)

implementation(compose.material3) // Change it material to material3

```