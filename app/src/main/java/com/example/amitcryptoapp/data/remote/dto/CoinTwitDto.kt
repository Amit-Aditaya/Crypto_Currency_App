package com.example.amitcryptoapp.data.remote.dto

import com.example.amitcryptoapp.domain.model.CoinTwit

data class CoinTwitDto(
    val date: String,
    val is_retweet: Boolean,
    val like_count: Int,
    val retweet_count: Int,
    val status: String,
    val status_id: String,
    val status_link: String,
    val user_image_link: String,
    val user_name: String
)

fun CoinTwitDto.toCoinTwit(): CoinTwit {
    return CoinTwit(
        userImage = user_image_link,
        userName = user_name,
        status = status,
        date = date
    )
}