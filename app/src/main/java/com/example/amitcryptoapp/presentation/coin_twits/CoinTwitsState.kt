package com.example.amitcryptoapp.presentation.coin_twits

import com.example.amitcryptoapp.domain.model.Coin
import com.example.amitcryptoapp.domain.model.CoinTwit

data class CoinTwitsState(
    val isLoading : Boolean = false,
    val coinTwits  : List<CoinTwit> = emptyList(),
    val error : String = ""
)
