package com.example.amitcryptoapp.presentation


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.amitcryptoapp.domain.model.Coin
import com.example.amitcryptoapp.presentation.coin_detail.CoinDetailScreen
import com.example.amitcryptoapp.presentation.coin_list.CoinListScreen
import com.example.amitcryptoapp.presentation.ui.theme.AmitCryptoAppTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.ui.graphics.Color

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalLayoutApi::class)
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            AmitCryptoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                  //  color = MaterialTheme.colorScheme.secondary
                    color = Color(0xff282828)
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}"
                        ) {
                            CoinDetailScreen(navController = navController)
                        }
                    }

                }
            }
        }
    }
}

