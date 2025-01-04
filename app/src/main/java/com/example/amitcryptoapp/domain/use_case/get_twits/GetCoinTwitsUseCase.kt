package com.example.amitcryptoapp.domain.use_case.get_coins

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.amitcryptoapp.common.Resource
import com.example.amitcryptoapp.data.remote.dto.toCoin
import com.example.amitcryptoapp.data.remote.dto.toCoinTwit
import com.example.amitcryptoapp.domain.model.Coin
import com.example.amitcryptoapp.domain.model.CoinTwit
import com.example.amitcryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

import javax.inject.Inject

class GetCoinTweetsUseCase @Inject constructor(private val repository: CoinRepository) {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(coinId:String): Flow<Resource<List<CoinTwit>>> = flow {
        try {
            emit(Resource.Loading<List<CoinTwit>>())
            val coinTwits = repository.getCoinTwits(coinId).map { it.toCoinTwit() }
            emit(Resource.Success<List<CoinTwit>>(coinTwits))
        }
        catch (e: HttpException) {
            emit((Resource.Error(e.localizedMessage ?: "An unexpected error occurred")))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        } catch (e: Exception) {
            // Catch any other unexpected exceptions
            emit(Resource.Error(message = "Something went wrong. Please try again later."))
        }

    }
}