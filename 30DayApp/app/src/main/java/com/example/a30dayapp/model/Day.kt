package com.example.a30dayapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30dayapp.R

data class Day(
    @StringRes val dayTitle: Int,
    @StringRes val dayText: Int,
    @DrawableRes val dayImage: Int
)

