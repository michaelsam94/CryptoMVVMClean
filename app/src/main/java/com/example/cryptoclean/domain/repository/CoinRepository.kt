package com.example.cryptoclean.domain.repository

import com.example.cryptoclean.data.remote.dto.CoinDto
import io.reactivex.Single

interface CoinRepository {

    fun getCoins(): Single<List<CoinDto>>
}