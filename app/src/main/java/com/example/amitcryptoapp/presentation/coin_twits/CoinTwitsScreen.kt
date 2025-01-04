package com.example.amitcryptoapp.presentation.coin_twits

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.amitcryptoapp.presentation.Screen
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amitcryptoapp.R
import com.example.amitcryptoapp.presentation.coin_list.components.CoinListItem
import com.example.amitcryptoapp.presentation.ui.texts.IsoToText


@RequiresApi(35)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CoinTwitsScreen(
    navController: NavController,
    viewModel: CoinTwitsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )

        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        if (state.coinTwits.isEmpty() && state.error.isEmpty() && !state.isLoading) {
            Text(
                text = " Sorry, there are no tweets to show :(",
                color = Color.Green,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )

        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(15.dp))
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    },
                    modifier = Modifier.size(24.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back button",
                        tint = Color.LightGray
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
            items(state.coinTwits) { coinTwits ->
                Column {
                    Row(
                        //    horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                vertical = 15.dp,
                            )
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(
                                    "https:${
                                        coinTwits.userImage.split(":").toTypedArray().last()
                                    }"
                                )
                                .crossfade(true)
                                .placeholder(R.drawable.ic_image_loading) // Replace with a drawable resource
                                .error(R.drawable.ic_no_image) // Replace with a drawable resource
                                .build(),
                            contentDescription = "user image",
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop,
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Column {
                            Text(text = coinTwits.userName, color = Color.White)
                            IsoToText(isoDate = coinTwits.date)
                        }
                    }
                    
                    Text(text = coinTwits.status, color = Color.LightGray)
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider()

                }
            }

        }


    }


}