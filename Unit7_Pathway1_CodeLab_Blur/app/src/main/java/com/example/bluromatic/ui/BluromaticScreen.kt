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

package com.example.bluromatic.ui

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bluromatic.R
import com.example.bluromatic.data.BlurAmount
import com.example.bluromatic.ui.theme.BluromaticTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.math.roundToInt

@Composable
fun BluromaticScreen(blurViewModel: BlurViewModel = viewModel(factory = BlurViewModel.Factory)) {
    val uiState by blurViewModel.blurUiState.collectAsStateWithLifecycle()
    var currentScreen by remember { mutableStateOf("main") }

    when (currentScreen) {
        "blur" -> {
            // Hiển thị màn hình blur dần
            BlurringImageScreen(
                onClose = {
                    currentScreen = "main"
                }
            )
        }
        else -> {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
            ) {
                BluromaticScreenContent(
                    blurUiState = uiState,
                    blurAmountOptions = blurViewModel.blurAmount,
                    applyBlur = blurViewModel::applyBlur,
                    cancelWork = blurViewModel::cancelWork,
                    onShowBlurringScreen = {
                        currentScreen = "blur"
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
        }
    }
}



@Composable
fun BlurringImageScreen(
    onClose: () -> Unit,
    durationMs: Int = 10000
) {
    var shouldAnimate by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        shouldAnimate = true
    }

    val whiteProgress by animateFloatAsState(
        targetValue = if (shouldAnimate) 1f else 0f,
        animationSpec = tween(durationMillis = durationMs, easing = LinearEasing),
    )

    Log.d("whiteProgress hien tai", whiteProgress.toString())
    Box(Modifier.fillMaxSize().background(Color.White)) {
            // ảnh cake gồm cả nền
        Image(
            painter = painterResource(R.drawable.android_cupcake),
            contentDescription = null,
            modifier = Modifier
                .matchParentSize(),
            contentScale = ContentScale.Fit
        )
            // trắng
        Box(
            Modifier
                .matchParentSize()
                .background(Color.White.copy(alpha = whiteProgress))
        )
            // ảnh cake png đã xóa nền
        Image(
            painter = painterResource(R.drawable.android_cupcake_photoroom),
            contentDescription = null,
            modifier = Modifier
                .matchParentSize(),
            contentScale = ContentScale.Fit
        )

        IconButton(
            onClick = onClose,
            modifier = Modifier
                .align(Alignment.TopStart)
                .statusBarsPadding()
                .padding(8.dp)
                .size(48.dp)
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
        }
    }
}


@Composable
fun BluromaticScreenContent(
    blurUiState: BlurUiState,
    blurAmountOptions: List<BlurAmount>,
    applyBlur: (Int) -> Unit,
    cancelWork: () -> Unit,
    onShowBlurringScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedValue by rememberSaveable { mutableStateOf(1) }
    val context = LocalContext.current

    Column(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.android_cupcake),
            contentDescription = stringResource(R.string.description_image),
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentScale = ContentScale.Fit,
        )
        BlurAmountContent(
            selectedValue = selectedValue,
            blurAmounts = blurAmountOptions,
            modifier = Modifier.fillMaxWidth(),
            onSelectedValueChange = { selectedValue = it }
        )
        BlurActions(
            blurUiState = blurUiState,
            onStartClick = { applyBlur(selectedValue) },
            onSeeFileClick = { currentUri ->
                showBlurredImage(context, currentUri)
            },
            onTransClick = {
                onShowBlurringScreen()
            },
            onCancelClick = { cancelWork() },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun BlurActions(
    blurUiState: BlurUiState,
    onStartClick: () -> Unit,
    onSeeFileClick: (String) -> Unit,
    onTransClick: () -> Unit,
    onCancelClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        when (blurUiState) {
            is BlurUiState.Default -> {
                Button(
                    onClick = onStartClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(stringResource(R.string.start))
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Nút Trans - Hiển thị ảnh blur dần
                OutlinedButton(
                    onClick =  onTransClick ,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Trans - View with Remove Background Effect")
                }
            }

            is BlurUiState.Loading -> {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FilledTonalButton(onCancelClick) {
                        Text(stringResource(R.string.cancel_work))
                    }
                    CircularProgressIndicator(
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    )
                }
            }

            is BlurUiState.Complete -> {
                // Hàng đầu tiên: Start và See File
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = onStartClick,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(stringResource(R.string.start))
                    }
                    FilledTonalButton(
                        onClick = { onSeeFileClick(blurUiState.outputUri) },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(stringResource(R.string.see_file))
                    }
                }
                // Nút Trans - Hiển thị ảnh blur dần
                OutlinedButton(
                    onClick =  onTransClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Trans - View with Remove Background Effect")
                }
            }
        }
    }
}

@Composable
private fun BlurAmountContent(
    selectedValue: Int,
    blurAmounts: List<BlurAmount>,
    modifier: Modifier = Modifier,
    onSelectedValueChange: (Int) -> Unit
) {
    Column(
        modifier = modifier.selectableGroup()
    ) {
        Text(
            text = stringResource(R.string.blur_title),
            style = MaterialTheme.typography.headlineSmall
        )
        blurAmounts.forEach { amount ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        role = Role.RadioButton,
                        selected = (selectedValue == amount.blurAmount),
                        onClick = { onSelectedValueChange(amount.blurAmount) }
                    )
                    .size(48.dp)
            ) {
                RadioButton(
                    selected = (selectedValue == amount.blurAmount),
                    onClick = null,
                    modifier = Modifier.size(48.dp),
                    colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colorScheme.primary
                    )
                )
                Text(stringResource(amount.blurAmountRes))
            }
        }
    }
}

private fun showBlurredImage(context: Context, currentUri: String) {
    val uri = if (currentUri.isNotEmpty()) {
        Uri.parse(currentUri)
    } else {
        null
    }
    val actionView = Intent(Intent.ACTION_VIEW, uri)
    context.startActivity(actionView)
}

@Preview(showBackground = true)
@Composable
fun BluromaticScreenContentPreview() {
    BluromaticTheme {
        BluromaticScreenContent(
            blurUiState = BlurUiState.Complete("content://test"),
            blurAmountOptions = listOf(BlurAmount(R.string.blur_lv_1, 1)),
            {},
            {},
            {},
            modifier = Modifier.padding(16.dp)
        )
    }
}