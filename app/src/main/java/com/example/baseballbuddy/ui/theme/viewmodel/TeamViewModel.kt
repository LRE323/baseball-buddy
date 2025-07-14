package com.example.baseballbuddy.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baseballbuddy.ui.theme.UiState
import com.example.baseballbuddy.ui.theme.models.Team
import com.example.baseballbuddy.ui.theme.repositories.TeamRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TeamViewModel(
    private val repository: TeamRepository = TeamRepository()
) : ViewModel() {

    private val _teams = MutableStateFlow<UiState<List<Team>>>(UiState.Loading)
//    val teams: StateFlow<UiState<List<Team>>> = _teams
    val teams: List<Team>? = when (val state = _teams.value) {
        is UiState.Success -> state.data
        else -> null
    }

    fun fetchTeams() {
        viewModelScope.launch {
            _teams.value = UiState.Loading
            try {
                val result = repository.getTeams()
                _teams.value = UiState.Success(result)
            } catch (e: Exception) {
                _teams.value = UiState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }
}