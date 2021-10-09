package com.example.cryptoclean.data.remote

import com.example.cryptoclean.data.remote.dto.CoinDto
import io.reactivex.Single
import retrofit2.http.GET

interface CoinApi {

    @GET("/v1/coins")
    fun getCoins(): Single<List<CoinDto>>
}