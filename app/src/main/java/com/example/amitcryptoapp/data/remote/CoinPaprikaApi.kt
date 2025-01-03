package com.example.amitcryptoapp.data.remote

import com.example.amitcryptoapp.data.remote.dto.CoinDetailDto
import com.example.amitcryptoapp.data.remote.dto.CoinDto
import com.example.amitcryptoapp.data.remote.dto.CoinTwitDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById (@Path("coinId") coinId : String) : CoinDetailDto

    @GET("/v1/coins/{coinId}/twitter")
    suspend fun getCoinTwits (@Path("coinId") coinId : String) : List<CoinTwitDto>

}