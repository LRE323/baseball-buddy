package com.example.baseballbuddy.ui.theme.models

import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("id")
    val id: Int,

    @SerializedName("first_name")
    val firstName: String,

    @SerializedName("last_name")
    val lastName: String,

    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("debut_year")
    val debutYear: Int,

    @SerializedName("jersey")
    val jersey: String,

    /**
     * Nullable because not all players go to college.
     */
    @SerializedName("college")
    val college: String? = null,

    @SerializedName("position")
    val position: String,

    @SerializedName("active")
    val active: Boolean,

    @SerializedName("birth_place")
    val birthPlace: String,

    @SerializedName("dob")
    val dob: String,

    @SerializedName("age")
    val age: Int,

    @SerializedName("height")
    val height: String,

    @SerializedName("weight")
    val weight: String,

    /**
     * Nullable because international players are not drafted.
     * So this value may be null for international players.
     */
    @SerializedName("draft")
    val draft: String? = null,

    @SerializedName("bats_throws")
    val batsThrows: String,

    /**
     * Nullable because if a player is a free agent, this may come as null.
     */
    @SerializedName("team")
    val team: Team? = null
)
