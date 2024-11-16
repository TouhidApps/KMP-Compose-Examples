package com.touhidapps.nav.composeNavigation

sealed class AppRoute(var route: String) {
    data object Input: AppRoute("input")
    data object Output: AppRoute("output/{name}") {
        fun getRoute(name: String) = "output/$name"
    }
}