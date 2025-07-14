package com.example.baseballbuddy.ui.theme.models

import com.google.gson.annotations.SerializedName

data class TeamListResponse(
    @SerializedName("data")
    val data: List<Team>
)