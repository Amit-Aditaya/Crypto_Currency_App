package com.example.amitcryptoapp.domain.use_case.get_coin

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.amitcryptoapp.common.Resource
import com.example.amitcryptoapp.data.remote.dto.toCoin
import com.example.amitcryptoapp.data.remote.dto.toCoinDetail
import com.example.amitcryptoapp.domain.model.Coin
import com.example.amitcryptoapp.domain.model.CoinDetail
import com.example.amitcryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.HTTP
import java.io.IOException

import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit((Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred")))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}