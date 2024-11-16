package com.touhidapps.nav.tab

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerTabScreen(
    modifier: Modifier = Modifier,
    startTabIndex: Int = 0,
) {

    var tabIndex by remember { mutableStateOf(startTabIndex) }
    val tabTitles = listOf("Tab 1", "Tab 2", "Tab 3")
    val pagerState = rememberPagerState(initialPage = tabIndex) { tabTitles.size }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxWidth()
//        modifier = modifier.fillMaxSize()
    ) {

        TabRow(selectedTabIndex = pagerState.currentPage) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        tabIndex = index
                        coroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    },
                    text = { Text(title) }
                )
            }
        } // TabRow

        HorizontalPager(state = pagerState) { page ->
            when (page) {

                0 -> {
                    Text(
                        "This is tab 1",
                        modifier = Modifier.padding(15.dp).background(Color.Red).fillMaxSize()
                    )
                }

                1 -> {
                    Text(
                        "This is tab 2",
                        modifier = Modifier.padding(15.dp).background(Color.LightGray).fillMaxSize()
                    )

//                    RootBottomBarNav(navHostController = navHostController)
                }

                2 -> {
                    Text(
                        "This is tab 3",
                        modifier = Modifier.padding(15.dp).background(Color.Magenta).fillMaxSize()
                    )
                }

            } // when

        } // HorizontalPager

    }

} // HomeScreen



@Preview
@Composable
fun PagerTabScreenPreview() {
    val navController = rememberNavController()
    PagerTabScreen(
        startTabIndex = 0,
        modifier = Modifier
    )
}