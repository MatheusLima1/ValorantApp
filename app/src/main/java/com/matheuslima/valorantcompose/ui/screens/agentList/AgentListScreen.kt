package com.matheuslima.valorantcompose.ui.screens.agentList

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.ui.screens.agentList.components.AgentListItem
import com.matheuslima.valorantcompose.ui.screens.errorScreens.components.LottieAnimationComponent
import com.matheuslima.valorantcompose.ui.viewmodel.AgentListViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AgentListScreen(navController: NavController, viewModel: AgentListViewModel = hiltViewModel()) {
    val agentsResponse by viewModel.agents.collectAsState()

    Box(modifier = Modifier.fillMaxSize().background(com.matheuslima.valorantcompose.ui.theme.ValorantDark)) {
        when (agentsResponse) {
            is BaseResponse.Loading -> {
                LottieAnimationComponent(modifier = Modifier.align(Alignment.Center), rawUrl = R.raw.loading)
            }

            is BaseResponse.Success -> {
                val agents = (agentsResponse as BaseResponse.Success).data
                if (agents.isNotEmpty()) {
                    val pagerState = rememberPagerState(initialPage = 0) { agents.size }
                    VerticalPager(
                        state = pagerState,
                        modifier = Modifier.fillMaxSize(),
                        pageSize = PageSize.Fill
                    ) { page ->
                        AgentListItem(
                            agent = agents[page],
                            onItemClick = { agent ->
                                navController.navigate("${com.matheuslima.valorantcompose.ui.navigation.Routes.AGENT_DETAIL_SCREEN}/${agent.uuid}")
                            }
                        )
                    }
                }
            }

            is BaseResponse.Error -> {
                // Handle error
            }
        }
    }
}