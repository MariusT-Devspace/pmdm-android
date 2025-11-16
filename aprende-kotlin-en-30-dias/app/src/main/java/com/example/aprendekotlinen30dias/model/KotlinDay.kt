package com.example.aprendekotlinen30dias.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class KotlinDay(
    val day: Int,
    @param:DrawableRes val iconRes: Int,
    @param:StringRes val titleRes: Int,
    @param:StringRes val descriptionRes: Int
)