This is a Kotlin Multiplatform (Compose) project targeting Android, iOS, Web, Desktop

# Koin Dependency injection for all 4 platforms (Android, iOS, Web, Desktop)

Library:

```
koin = "4.0.0-RC1"
koin-compose = "1.2.0-Beta4"
```

```
koin-core = { module = "io.insert-koin:koin-core", version.ref = "koin" }
koin-compose = { module = "io.insert-koin:koin-compose", version.ref = "koin-compose" }
```

```
commonMain.dependencies {
    ...
    api(libs.koin.core)
    implementation(libs.koin.compose)
}
```

Code Screenshot:

![Koin DI Part 1](https://raw.githubusercontent.com/TouhidApps/KMP-Compose-Examples/main/Koin-Dependency-Injection-DI/img/img-1.png)

![Koin DI Part 2](https://raw.githubusercontent.com/TouhidApps/KMP-Compose-Examples/main/Koin-Dependency-Injection-DI/img/img-2.png)

