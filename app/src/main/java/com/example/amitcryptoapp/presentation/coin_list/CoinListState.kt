package com.example.amitcryptoapp.presentation.coin_list

import com.example.amitcryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coins  :List<Coin> = emptyList(),
    val error : String = ""
)
