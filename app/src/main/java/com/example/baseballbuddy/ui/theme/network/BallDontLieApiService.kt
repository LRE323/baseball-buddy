package com.example.baseballbuddy.ui.theme.network

import com.example.baseballbuddy.ui.theme.models.TeamListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BallDontLieApiService {

    @GET("mlb/v1/teams")
    suspend fun getTeams(
        @Query("league") league: String? = null,
        @Query("division") division: String? = null
    ): TeamListResponse

    @GET("mlb/v1/players")
    suspend fun getPlayers(): TeamListResponse
}