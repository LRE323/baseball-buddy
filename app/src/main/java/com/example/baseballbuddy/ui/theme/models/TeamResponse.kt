package com.example.baseballbuddy.ui.theme.models

import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @SerializedName("data")
    val data: List<Team>
)