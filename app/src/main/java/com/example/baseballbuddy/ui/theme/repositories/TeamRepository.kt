package com.example.baseballbuddy.ui.theme.repositories

import com.example.baseballbuddy.ui.theme.models.TeamListResponse
import com.example.baseballbuddy.ui.theme.network.BallDontLieNetworkModule

class TeamRepository {
    private val teamApiService = BallDontLieNetworkModule.ballDontLieApiService

    suspend fun getTeamListResponse(): TeamListResponse {
        return teamApiService.getTeams()
    }
}