package com.example.baseballbuddy.ui.theme.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    @SerializedName("id")
    val id: Int,

    @SerializedName("slug")
    val slug: String,

    @SerializedName("abbreviation")
    val abbreviation: String,

    @SerializedName("display_name")
    val displayName: String,

    @SerializedName("short_display_name")
    val shortDisplayName: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("location")
    val location: String,

    @SerializedName("league")
    val league: League,

    @SerializedName("division")
    val division: Division
): Parcelable