package com.example.baseballbuddy.ui.theme.models

import com.google.gson.annotations.SerializedName

enum class League {
    @SerializedName("American")
    AMERICAN,

    @SerializedName("National")
    NATIONAL;

    val serviceQueryLabel: String
        get() = when(this) {
        AMERICAN -> "American"
        NATIONAL -> "National"
    }
}