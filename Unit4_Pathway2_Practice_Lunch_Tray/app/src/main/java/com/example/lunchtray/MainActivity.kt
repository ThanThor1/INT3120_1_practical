/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.lunchtray

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lunchtray.ui.theme.LunchTrayTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.datasource.Screen
import com.example.lunchtray.ui.AccompanimentMenuScreen
import com.example.lunchtray.ui.CheckoutScreen
import com.example.lunchtray.ui.EntreeMenuScreen
import com.example.lunchtray.ui.SideDishMenuScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.navigation.NavHostController
import com.example.lunchtray.ui.OrderViewModel
import com.example.lunchtray.ui.StartOrderScreen



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LunchTrayTheme {
                LunchTrayApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayApp() {
    val navController = rememberNavController()
    val viewModel: OrderViewModel = viewModel()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screen.valueOf(
        backStackEntry?.destination?.route ?: Screen.START.name
    )
    Scaffold(
        topBar = {
            LunchTrayAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.START.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = Screen.START.name) {
                StartOrderScreen(
                    onStartOrderButtonClicked = {
                        navController.navigate(Screen.ENTREE.name)
                    }
                )
            }
            composable(route = Screen.ENTREE.name) {
                EntreeMenuScreen(
                    options = DataSource.entreeMenuItems,
                    onCancelButtonClicked = {
                        restart(viewModel, navController)
                    },
                    onNextButtonClicked = {
                        navController.navigate(Screen.SIDE_DISH.name)
                    },
                    onSelectionChanged = { item ->
                        viewModel.updateEntree(item)
                    }
                )
            }
            composable(route = Screen.SIDE_DISH.name) {
                SideDishMenuScreen(
                    options = DataSource.sideDishMenuItems,
                    onCancelButtonClicked = {
                        restart(viewModel, navController)
                    },
                    onNextButtonClicked = {
                        navController.navigate(Screen.ACCOMPANIMENT.name)
                    },
                    onSelectionChanged = { item ->
                        viewModel.updateSideDish(item)
                    }
                )
            }
            composable(route = Screen.ACCOMPANIMENT.name) {
                AccompanimentMenuScreen(
                    options = DataSource.accompanimentMenuItems,
                    onCancelButtonClicked = {
                        restart(viewModel, navController)
                    },
                    onNextButtonClicked = {
                        navController.navigate(Screen.CHECKOUT.name)
                    },
                    onSelectionChanged = { item ->
                        viewModel.updateAccompaniment(item)
                    }
                )
            }
            composable(route = Screen.CHECKOUT.name) {
                val uiState by viewModel.uiState.collectAsState()
                CheckoutScreen(
                    orderUiState = uiState,
                    onCancelButtonClicked = {
                        restart(viewModel, navController)
                    },
                    onNextButtonClicked = {
                        restart(viewModel, navController)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayAppBar(
    currentScreen: Screen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = when (currentScreen) {
                    Screen.START -> "Lunch Tray"
                    Screen.ENTREE -> "Choose Entree"
                    Screen.SIDE_DISH -> "Choose Side Dish"
                    Screen.ACCOMPANIMENT -> "Choose Accompaniment"
                    Screen.CHECKOUT -> "Order Checkout"
                },
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        },
        navigationIcon = {
            if (canNavigateBack && currentScreen != Screen.START) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        modifier = modifier
    )
}

private fun restart(
    viewModel: OrderViewModel,
    navController: NavHostController
) {
    viewModel.resetOrder()
    navController.popBackStack(Screen.START.name, inclusive = false)
}
