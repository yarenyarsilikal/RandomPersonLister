package com.yarenyarsilikal.randompersonlister.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.yarenyarsilikal.randompersonlister.R
import com.yarenyarsilikal.randompersonlister.domain.model.Person
import com.yarenyarsilikal.randompersonlister.ui.main.components.PeopleListItem
import com.yarenyarsilikal.randompersonlister.ui.main.components.paging.PagingErrorItem
import com.yarenyarsilikal.randompersonlister.ui.main.components.paging.PagingErrorMessage
import com.yarenyarsilikal.randompersonlister.ui.main.components.paging.PagingLoadingItem
import com.yarenyarsilikal.randompersonlister.ui.main.components.paging.PagingLoadingView

/**
 * Created by yarenyarsilikal on 16.04.2022.
 */

@Composable
fun PeopleListScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val rememberSwipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
    val lazyPagingItems = viewModel.getPeople().collectAsLazyPagingItems()
    SwipeRefresh(modifier = modifier,
        state = rememberSwipeRefreshState,
        onRefresh = {
            lazyPagingItems.refresh()
        },
        indicator = { state, trigger ->
            SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = trigger,
                scale = true,
                backgroundColor = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.small,
            )
        }) {
        rememberSwipeRefreshState.isRefreshing =
            lazyPagingItems.loadState.refresh is LoadState.Loading && lazyPagingItems.itemCount > 0

        PeopleList(lazyPagingItems = lazyPagingItems)

    }

}

@Composable
fun PeopleList(lazyPagingItems: LazyPagingItems<Person>) {
    LazyColumn(modifier = Modifier.fillMaxSize(), state = rememberLazyListState()) {
        items(lazyPagingItems) { item ->
            if (item != null) {
                PeopleListItem(person = item)
            }
        }

        lazyPagingItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item {
                        PagingLoadingView(modifier = Modifier.fillParentMaxSize())
                    }
                }

                loadState.append is LoadState.Loading -> {
                    item {
                        PagingLoadingItem()
                    }
                }

                loadState.refresh is LoadState.Error -> {
                    val state = lazyPagingItems.loadState.refresh as LoadState.Error
                    item {
                        PagingErrorMessage(
                            modifier = Modifier.fillParentMaxSize(),
                            message = state.error.localizedMessage
                                ?: stringResource(R.string.generic_error_message),
                            onRetryClick = { retry() }
                        )
                    }
                }

                loadState.append is LoadState.Error -> {
                    val state = lazyPagingItems.loadState.append as LoadState.Error
                    item {
                        PagingErrorItem(
                            message = state.error.localizedMessage
                                ?: stringResource(R.string.generic_error_message),
                            onRetryClick = { retry() }
                        )
                    }
                }
            }
        }
    }

}
