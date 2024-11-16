package com.touhidapps.nav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.compose.rememberNavController
import com.touhidapps.nav.bottomBar.BottomNavigationBar
import com.touhidapps.nav.bottomBar.RootBottomBarNav
import com.touhidapps.nav.bottomSheet.ModalBottomSheetContent
import com.touhidapps.nav.composeNavigation.MyNavHostScreen
import com.touhidapps.nav.dialog.DialogScreen
import com.touhidapps.nav.drawerMenu.NavigationDrawerContent
import com.touhidapps.nav.tab.PagerTabScreen
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {

    MaterialTheme {

        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        // 1. MARK Navigation Drawer Menu START ----------------------

        ModalNavigationDrawer(
            drawerContent = {
                NavigationDrawerContent(modifier = Modifier.fillMaxWidth(0.75f)) {
                    scope.launch {
                        drawerState.close()
                    }
                }
            },
            scrimColor = Color.Black.copy(alpha = 0.30f),
            drawerState = drawerState

        // 1. MARK Navigation Drawer Menu END ----------------------

        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Navigation & Material Design 3", style = TextStyle(color = Color.White)) },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(Icons.Filled.Menu, contentDescription = "Drawer menu button", tint = Color.White)
                            }
                        }
                    )
                }
            ) {
                Column {

                    Spacer(
                        modifier = Modifier.height(60.dp)
                    )

                    // 2. MARK Alert dialog START ----------------------

                    var isShowAlertDialog by remember { mutableStateOf(false) }

                    if (isShowAlertDialog) {
                        Dialog(onDismissRequest = {
                            isShowAlertDialog = false /* Click outside will dismiss the dialog */
                        }) {
                            DialogScreen {
                                isShowAlertDialog = false
                            }
                        }
                    }

                    Button(onClick = {
                        isShowAlertDialog = true
                    }) {
                        Text(text = "Alert Dialog")
                    }

                    // 2. MARK Alert dialog END ------------------------

                    // 3. MARK Pager Tab START --------------------------

                    PagerTabScreen(
                        startTabIndex = 0,
                        modifier = Modifier.height(200.dp)
                    )

                    // 3. MARK Pager Tab END ----------------------------

                    // 4. MARK Compose Navigation START --------------------

                    val nhc = rememberNavController()
                    Box(
                        modifier = Modifier.height(180.dp)
                    ) {
                        MyNavHostScreen(
                            modifier = Modifier,
                            navHostController = nhc
                        )
                    }

                    // 4. MARK Compose Navigation END ----------------------

                    // 5. MARK Bottom Bar START ----------------------
                    val nhc2 = rememberNavController()
                    Scaffold(
                        modifier = Modifier.height(150.dp),
                        bottomBar = {
                            // Bottom bar content
                            BottomNavigationBar(nhc2) {
                                println("Selected tab: ${it.title}")
                            }
                        }
                    ) {
                        RootBottomBarNav(nhc2) // Nav Host
                    }
                    // 5. MARK Bottom Bar END -------------------------


                    // 6. MARK Bottom Sheet START -------------------------

                    val sheetState = rememberModalBottomSheetState() // material3
                    var showBottomSheet by remember { mutableStateOf(false) }

                    Scaffold(
                        floatingActionButton = {
                            ExtendedFloatingActionButton(
                                text = { Text("Show Bottom Sheet") },
                                icon = { Icon(imageVector = Icons.Rounded.Add, contentDescription = "Show Bottom Sheet Button") },
                                onClick = {
                                    showBottomSheet = true
                                }
                            )
                        }

                    ) {

                        if (showBottomSheet) {
                            ModalBottomSheet(  // material3
                                onDismissRequest = {
                                    showBottomSheet = false
                                },
                                sheetState = sheetState
                            ) {
                                ModalBottomSheetContent {
                                    scope.launch {
                                        sheetState.hide()
                                    }.invokeOnCompletion {
                                        if (!sheetState.isVisible) {
                                            showBottomSheet = false
                                        }
                                    }
                                }
                            }
                        }

                    }

                    // 6. MARK Bottom Sheet END ---------------------------


                } // Root Column
            }
        }








    }
}

