package com.hari.notty.ui.notes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.hari.notty.ui.components.LoadingState
import com.hari.notty.ui.components.NoteCard
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun AllNoteScreen(
    navigator: DestinationsNavigator
) {
    val pages = (0..15).map { "Tab$it" }
    val pagerState = rememberPagerState()


    Column(
        modifier = Modifier.navigationBarsPadding()
    ) {
        ScrollableTabRow(
            // Our selected tab is our current page
            selectedTabIndex = pagerState.currentPage,
            edgePadding = 0.dp,
            // Override the indicator, using the provided pagerTabIndicatorOffset modifier
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .pagerTabIndicatorOffset(pagerState, tabPositions)
                        .padding(horizontal = 16.dp)
                )
            },
            divider = {}
        ) {
            // Add tabs for all of our pages
            pages.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = pagerState.currentPage == index,
                    onClick = { },
                )
            }
        }

        @OptIn(ExperimentalFoundationApi::class)
        HorizontalPager(
            count = pages.size,
            state = pagerState,
        ) { page ->

            if (page == 0) {
                LoadingState()
            } else if (page == 1) {
                LoadingState(
                    isLoading = false,
                    error = Throwable()
                )
            } else {
                LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(10) { NoteCard() }

                }
            }
        }

    }


}