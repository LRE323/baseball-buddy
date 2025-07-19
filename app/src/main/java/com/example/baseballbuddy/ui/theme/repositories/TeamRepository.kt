package com.example.baseballbuddy.ui.theme.repositories

import com.example.baseballbuddy.ui.theme.models.TeamListResponse
import com.example.baseballbuddy.ui.theme.network.BallDontLieNetworkModule
import com.example.baseballbuddy.ui.theme.network.BallDontLieTeamsRequest

class TeamRepository {
    private val teamApiService = BallDontLieNetworkModule.ballDontLieApiService

    suspend fun getTeamListResponse(request: BallDontLieTeamsRequest? = null): TeamListResponse {
        return teamApiService.getTeams(
            league = request?.league?.serviceQueryLabel,
            division = request?.division?.serviceQueryLabel
        )
    }
}