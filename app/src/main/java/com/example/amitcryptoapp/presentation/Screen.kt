package com.example.amitcryptoapp.presentation

sealed class Screen (val route : String) {

    object CoinListScreen : Screen ("coin_list_screen")
    object  CoinDetailScreen : Screen ("coin_detail_screen")
    object  CoinTwitsScreen : Screen ("coin_twits_screen")

}