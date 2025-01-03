package com.example.amitcryptoapp.data.repository

import android.util.Log
import com.example.amitcryptoapp.data.remote.CoinPaprikaApi
import com.example.amitcryptoapp.data.remote.dto.CoinDetailDto
import com.example.amitcryptoapp.data.remote.dto.CoinDto
import com.example.amitcryptoapp.data.remote.dto.CoinTwitDto
import com.example.amitcryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api :CoinPaprikaApi) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {

        return  api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return  api.getCoinById(coinId)
    }

    override suspend fun getCoinTwits(coinId: String): List<CoinTwitDto> {
        return  api.getCoinTwits(coinId)
    }
}