package com.example.amitcryptoapp.presentation.coin_detail

import com.example.amitcryptoapp.domain.model.Coin
import com.example.amitcryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coin  : CoinDetail? = null,
    val error : String = ""
)
