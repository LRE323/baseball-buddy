package com.example.baseballbuddy.ui.theme.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.baseballbuddy.ui.theme.BaseballBuddyTheme
import com.example.baseballbuddy.ui.theme.BundleKeys
import com.example.baseballbuddy.ui.theme.models.Team

class TeamInfoActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseballBuddyTheme {
                TeamInfoScreen(getTeamFromExtras(intent.extras))
            }
        }
    }

    private fun getTeamFromExtras(extras: Bundle?): Team? {
        extras?.apply {
            getParcelable(BundleKeys.TEAM_KEY, Team::class.java)
        }
        return null
    }
}

@Composable
fun TeamInfoScreen(team: Team?) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TeamInfoScreenTopAppBar(team)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamInfoScreenTopAppBar(team: Team?) {
    TopAppBar(
        title = {
            team?.displayName?.apply {
                Text(this)
            }
        }
    )
}