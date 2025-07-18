package com.example.baseballbuddy.ui.theme.network

import com.example.baseballbuddy.ui.theme.models.TeamListResponse
import retrofit2.http.GET

interface BallDontLieApiService {

    @GET("mlb/v1/teams")
    suspend fun getTeams(): TeamListResponse

    @GET("mlb/v1/players")
    suspend fun getPlayers(): TeamListResponse
}