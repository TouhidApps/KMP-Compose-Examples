This is a Kotlin Multiplatform (Compose) project targeting Android, iOS, Web, Desktop

# Koin Dependency injection for all 4 platforms (Android, iOS, Web, Desktop)

Library:

```
# Koin
koin = "4.0.0-RC1"
koin-compose = "1.2.0-Beta4"

koinAndroidCompose = "3.6.0-alpha3"

# ViewModel
lifecycleViewModel = "2.8.0"

# Navigation
navigationCompose = "2.7.0-alpha03"

# Coroutines
kotlinxCoroutines = "1.8.0"
```

```
# Koin Dependency Injection
koin-core = { module = "io.insert-koin:koin-core", version.ref = "koin" }
koin-compose = { module = "io.insert-koin:koin-compose", version.ref = "koin-compose" }

koin-android = { module = "io.insert-koin:koin-android", version.ref = "koin" }
koin-androidx-compose = { module = "io.insert-koin:koin-androidx-compose", version.ref = "koinAndroidCompose" }

# ViewModel
lifecycle-viewmodel = { module = "androidx.lifecycle:lifecycle-viewmodel", version.ref = "lifecycleViewModel" }

# Navigation
navigation-compose = { module = "org.jetbrains.androidx.navigation:navigation-compose", version.ref = "navigationCompose" }

# Coroutines
kotlinx-coroutines-core = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-core", version.ref = "kotlinxCoroutines" }
kotlinx-coroutines-android = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-android", version.ref = "kotlinxCoroutines" }
kotlinx-coroutines-swing = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-swing", version.ref = "kotlinxCoroutines" }

```

```
commonMain.dependencies {
    ...
    api(libs.koin.core)
    implementation(libs.koin.compose)
}
```

```
androidMain.dependencies {
    ...

    // Koin
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)
}
```

```
commonMain.dependencies {
    ...
    // Koin
    api(libs.koin.core)
    implementation(libs.koin.compose)

    // ViewModel
//            implementation(libs.lifecycle.viewmodel)

    // Navigation
    implementation(libs.navigation.compose)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
}
```

```
desktopMain.dependencies {
    ...
    // Coroutines
    implementation(libs.kotlinx.coroutines.swing)
}
```

Code Screenshot:

![ViewModel & Koin 2](https://raw.githubusercontent.com/TouhidApps/KMP-Compose-Examples/main/ViewModel%20KMP%20Compose/img/img-2.png)

![ViewModel & Koin 1](https://raw.githubusercontent.com/TouhidApps/KMP-Compose-Examples/main/ViewModel%20KMP%20Compose/img/img-2.png)

