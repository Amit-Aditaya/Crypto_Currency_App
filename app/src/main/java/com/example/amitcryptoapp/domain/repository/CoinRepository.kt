package com.example.amitcryptoapp.domain.repository

import com.example.amitcryptoapp.data.remote.dto.CoinDetailDto
import com.example.amitcryptoapp.data.remote.dto.CoinDto
import com.example.amitcryptoapp.data.remote.dto.CoinTwitDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId : String): CoinDetailDto

    suspend fun getCoinTwits(coinId : String): List<CoinTwitDto>

}