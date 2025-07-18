package com.example.baseballbuddy.ui.theme.network

import com.example.baseballbuddy.ui.theme.models.TeamListResponse
import retrofit2.http.GET

interface TeamApiService {

    @GET("mlb/v1/teams")
    suspend fun getTeams(): TeamListResponse
}