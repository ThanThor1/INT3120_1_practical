package com.example.unit3_pathway2_practice_build_a_grid
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val idCategory: Int,
    @DrawableRes val imageResourceId: Int
)