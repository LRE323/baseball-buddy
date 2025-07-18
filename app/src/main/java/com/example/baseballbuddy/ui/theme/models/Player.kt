package com.example.baseballbuddy.ui.theme.models

import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("first_name")
    val firstName: String? = null,

    @SerializedName("last_name")
    val lastName: String? = null,

    @SerializedName("full_name")
    val fullName: String? = null,

    @SerializedName("debut_year")
    val debutYear: Int? = null,

    @SerializedName("jersey")
    val jersey: String? = null,

    @SerializedName("college")
    val college: String? = null,

    @SerializedName("position")
    val position: String? = null,

    @SerializedName("active")
    val active: Boolean? = null,

    @SerializedName("birth_place")
    val birthPlace: String? = null,

    @SerializedName("dob")
    val dob: String? = null,

    @SerializedName("age")
    val age: Int? = null,

    @SerializedName("height")
    val height: String? = null,

    @SerializedName("weight")
    val weight: String? = null,

    @SerializedName("draft")
    val draft: String? = null,

    @SerializedName("bats_throws")
    val batsThrows: String? = null,

    @SerializedName("team")
    val team: Team? = null
)
