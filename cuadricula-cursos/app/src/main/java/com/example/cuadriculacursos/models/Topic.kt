package com.example.cuadriculacursos.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @param:StringRes val titleResId: Int,
    val numberOfCourses: Int,
    @param:DrawableRes val imageResId: Int
)
