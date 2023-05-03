package com.example.formula1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Driver(
    val name: String,
    val description: String,
    val photo: Int,
    val team: String
) : Parcelable
