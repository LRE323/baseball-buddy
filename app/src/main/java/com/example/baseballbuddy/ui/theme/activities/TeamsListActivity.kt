package com.example.baseballbuddy.ui.theme.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.baseballbuddy.R
import com.example.baseballbuddy.ui.theme.BaseballBuddyTheme
import com.example.baseballbuddy.ui.theme.models.Team
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
        viewModel.fetchTeams()
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
            TeamListScreenHeader()

            val response by viewModel.teamListResponse.observeAsState(TeamListResponse())
            TeamLazyColumn(response?.data)
        }
    }
}

@Composable
fun TeamListScreenHeader() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = stringResource(R.string.team_list_screen_headline),
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
fun TeamLazyColumn(teamList: List<Team>?) {
    LazyColumn {
        items(teamList ?: emptyList()) {
            TeamLazyColumnItem(it)
        }
    }
}

@Composable
fun TeamLazyColumnItem(team: Team) {
    Text(
        text = team.displayName,
        style = MaterialTheme.typography.bodyLarge
    )
}
