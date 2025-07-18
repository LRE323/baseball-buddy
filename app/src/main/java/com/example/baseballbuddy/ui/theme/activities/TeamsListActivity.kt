package com.example.baseballbuddy.ui.theme.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.baseballbuddy.ui.theme.BaseballBuddyTheme
import com.example.baseballbuddy.ui.theme.models.TeamListResponse
import com.example.baseballbuddy.ui.theme.viewmodel.TeamViewModel

class TeamsListActivity: ComponentActivity() {
    private val viewModel: TeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseballBuddyTheme {
                TeamsListScreen(viewModel)
            }
        }
    }
}

@Composable
fun TeamsListScreen(viewModel: TeamViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            val response by viewModel.teamListResponse.observeAsState(TeamListResponse())
            TeamListResponseStatusText(response)

            FetchTeamListButton(
                onClickFetchTeams = { viewModel.fetchTeams() }
            )
        }
    }
}

@Composable
fun TeamListResponseStatusText(teamListResponse: TeamListResponse?) {
    fun getMessage(teamListResponse: TeamListResponse?): String {
        teamListResponse?.data?.apply {
            return "$size team(s) fetched"
        }
        return "Nothing fetched"
    }
    Text(text = getMessage(teamListResponse))
}


@Composable
fun FetchTeamListButton(onClickFetchTeams: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Button(onClick = onClickFetchTeams) {
            Text("Fetch Teams")
        }
    }
}
