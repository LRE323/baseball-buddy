package com.example.baseballbuddy.ui.theme.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baseballbuddy.ui.theme.models.Division
import com.example.baseballbuddy.ui.theme.models.League
import com.example.baseballbuddy.ui.theme.models.TeamListResponse
import com.example.baseballbuddy.ui.theme.network.BallDontLieTeamsRequest
import com.example.baseballbuddy.ui.theme.repositories.TeamRepository
import kotlinx.coroutines.launch

class TeamViewModel : ViewModel() {
    private val teamRepository: TeamRepository = TeamRepository()

    private val _teamListResponse: MutableLiveData<TeamListResponse?> = MutableLiveData()
    val teamListResponse: LiveData<TeamListResponse?> = _teamListResponse

    fun fetchTeams() {
        viewModelScope.launch {
            val response = teamRepository.getTeamListResponse(getTeamsRequest())
            _teamListResponse.value = response
        }
    }

    private fun getTeamsRequest(): BallDontLieTeamsRequest {
        return BallDontLieTeamsRequest(League.NATIONAL, Division.WEST)
    }
}