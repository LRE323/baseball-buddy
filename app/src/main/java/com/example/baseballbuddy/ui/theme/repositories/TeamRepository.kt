package com.example.baseballbuddy.ui.theme.repositories

import com.example.baseballbuddy.ui.theme.network.RetrofitInstance
import com.example.baseballbuddy.ui.theme.models.Team

class TeamRepository {
    suspend fun getTeams(): List<Team> {
        return RetrofitInstance.api.getTeams().data
    }
}