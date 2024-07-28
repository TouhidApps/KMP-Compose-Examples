This is a Kotlin Multiplatform project targeting Android, iOS, Web, Desktop, Server.

## Add libraries for Koin DI:

Versions:

```
koin = "3.6.0-Beta4"
koinComposeMultiplatform = "1.2.0-Beta4"
navigationCompose = "2.8.0-alpha02"
lifecycleViewModel = "2.8.2"
```

Libraries:

```
lifecycle-viewmodel = { module = "androidx.lifecycle:lifecycle-viewmodel", version.ref = "lifecycleViewModel"}
koin-android = { module = "io.insert-koin:koin-android", version.ref = "koin" }
koin-androidx-compose = { module = "io.insert-koin:koin-androidx-compose", version.ref = "koin" }
koin-core = { module = "io.insert-koin:koin-core", version.ref = "koin" }
koin-compose = { module = "io.insert-koin:koin-compose", version.ref = "koinComposeMultiplatform" }
koin-compose-viewmodel = { module = "io.insert-koin:koin-compose-viewmodel", version.ref = "koinComposeMultiplatform" }
navigation-compose = { module = "org.jetbrains.androidx.navigation:navigation-compose", version.ref = "navigationCompose" }
```

In gradle:

```
androidMain.dependencies {
    ...
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
}
commonMain.dependencies {
    ...
    api(libs.koin.core)
    implementation(libs.koin.compose)
    implementation(libs.koin.compose.viewmodel)
    implementation(libs.navigation.compose)
    implementation("com.arkivanov.essenty:lifecycle:2.1.0")
}
```




