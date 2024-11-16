This is a Kotlin Multiplatform project targeting Android, iOS, Web, Desktop.


## Navigation's & Material Design 3 ->

 1. Navigation Drawer Menu
 2. Alert dialog
 3. Pager & Tab
 4. Compose Navigation *
 5. Bottom Bar *
 6. Bottom Sheet

Preview:

https://github.com/TouhidApps/KMP-Compose-Examples/blob/main/KMP-Navigation/screenshots/navigation_video.mov


 4. Compose Navigation:

Library:

```
navigationCompose = "2.8.0-alpha10"
navigation-compose = { module = "org.jetbrains.androidx.navigation:navigation-compose", version.ref = "navigationCompose" }
```

```
commonMain.dependencies {
    implementation(libs.navigation.compose)
}
```


5. BottomBar Navigation:

Add library:
```
commonMain.dependencies {
   implementation(compose.material) -- this one already exists
   implementation(compose.material3) -- add this
}
```
