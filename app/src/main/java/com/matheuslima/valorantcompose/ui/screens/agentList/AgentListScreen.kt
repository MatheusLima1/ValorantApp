package com.matheuslima.valorantcompose.ui.screens.agentList

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.matheuslima.utilities.BaseResponse
import com.matheuslima.valorantcompose.R
import com.matheuslima.valorantcompose.ui.screens.agentList.components.AgentListItem
import com.matheuslima.valorantcompose.ui.screens.errorScreens.EmptyScreen
import com.matheuslima.valorantcompose.ui.screens.errorScreens.components.LottieAnimationComponent
import com.matheuslima.valorantcompose.ui.viewmodel.AgentListViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AgentListScreen(navController: NavController, viewModel: AgentListViewModel = hiltViewModel()) {
    //        navController.currentBackStackEntry.savedStateHandle["data"] = "shit"
//    var data = ""
//    LaunchedEffect(key1 = navController) {
//        data = navController.previousBackStackEntry.savedStateHandle.getStateFlow("data", "").toString()
//    }

    val agentsResponse by viewModel.agents.collectAsState()
    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f) {
        20
    }
    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page: Int ->
        when (agentsResponse) {
            is BaseResponse.Loading -> {
                LottieAnimationComponent(rawUrl = R.raw.loading)
            }

            is BaseResponse.Success -> {
                val response = (agentsResponse as BaseResponse.Success).data
                if (response.data.isNotEmpty()) {
//                    AgentListItem(agent = response.data.filter { agent -> agent.isPlayableCharacter == true }[page])
                    AgentListItem(agent = response.data[page])
                } else {
                    //TODO Create empty list
                }
            }

            is BaseResponse.Error -> {
                //TODO create error screen
                val error = (agentsResponse as BaseResponse.Error).error
                print("${error.message} -  ${error.stackTrace}")
            }

            else -> {}
        }
    }
}