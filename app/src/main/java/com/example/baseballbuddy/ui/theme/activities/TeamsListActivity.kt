package com.example.baseballbuddy.ui.theme.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
        setTitle()
        setContent {
            BaseballBuddyTheme {
                TeamsListScreen(viewModel, ::onClickTeam)
            }
        }
        viewModel.fetchTeams()
    }

    private fun onClickTeam(team: Team) {
        Toast.makeText(this, "Clicked ${team.displayName}", Toast.LENGTH_SHORT).show()
    }
    private fun setTitle() {
       title = getString(R.string.team_list_screen_headline)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamListScreenTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.team_list_screen_headline)
            )
        }
    )
}

@Composable
fun TeamsListScreen(viewModel: TeamViewModel, onClickTeam: (Team) -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TeamListScreenTopAppBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            val response by viewModel.teamListResponse.observeAsState(TeamListResponse())
            val teamLazyColumnModifier = Modifier
                .weight(1f)
                .fillMaxWidth()
            TeamLazyColumn(response?.data, teamLazyColumnModifier, onClickTeam)
        }
    }
}

@Composable
fun TeamLazyColumn(teamList: List<Team>?, modifier: Modifier, onClickTeam: (Team) -> Unit) {
    val teams = teamList ?: emptyList()

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.Top
    ) {
        itemsIndexed(teams) { index, team ->
            // TODO: Need to add Dividers for leagues and divisions
            if (index != 0) { // Do not add top divider for the first item
                TeamLazyColumnItemDivider()
            }
            TeamLazyColumnItem(team, onClickTeam)
            if (index != teams.lastIndex) { // do not add bottom divider to the last item
                TeamLazyColumnItemDivider()
            }
        }
    }
}

@Composable
fun TeamLazyColumnItem(
    team: Team,
    onClick: (Team) -> Unit
) {
    Text(
        text = team.displayName,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(team) }
            .padding(vertical = 32.dp)
    )
}

@Composable
fun TeamLazyColumnItemDivider() {
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth(),
        thickness = 1.dp
    )
}
