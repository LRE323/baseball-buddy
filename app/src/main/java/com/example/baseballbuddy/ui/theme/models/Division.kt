package com.example.baseballbuddy.ui.theme.models

import com.google.gson.annotations.SerializedName

enum class Division {

    @SerializedName("West")
    WEST,

    @SerializedName("Central")
    CENTRAL,

    @SerializedName("East")
    EAST;

    val serviceQueryLabel: String
        get() = when (this) {
            WEST -> "West"
            CENTRAL -> "Central"
            EAST -> "East"
        }

}