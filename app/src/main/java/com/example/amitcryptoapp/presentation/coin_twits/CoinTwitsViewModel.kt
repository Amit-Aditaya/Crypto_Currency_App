package com.example.amitcryptoapp.presentation.coin_twits

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amitcryptoapp.common.Constants
import com.example.amitcryptoapp.common.Resource
import com.example.amitcryptoapp.domain.use_case.get_coin.GetCoinUseCase
import com.example.amitcryptoapp.domain.use_case.get_coins.GetCoinTweetsUseCase
import com.example.amitcryptoapp.presentation.coin_detail.CoinDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class CoinTwitsViewModel @Inject constructor (
    private val getCoinTwitsUseCase: GetCoinTweetsUseCase,
    savedStateHandle: SavedStateHandle
) :ViewModel() {
    private  val _state = mutableStateOf(CoinTwitsState())
    val state : State<CoinTwitsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoinTwits(coinId)
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getCoinTwits(coinId : String){
        getCoinTwitsUseCase(coinId).onEach { result ->
            when (result){
                is Resource.Success -> _state.value = CoinTwitsState(coinTwits = result.data?: emptyList())
                is Resource.Loading -> _state.value = CoinTwitsState(isLoading = true)
                is Resource.Error -> _state.value = CoinTwitsState(error = result.message ?: "An unexpected error occurred")
            }

        }.launchIn(viewModelScope)
    }

}