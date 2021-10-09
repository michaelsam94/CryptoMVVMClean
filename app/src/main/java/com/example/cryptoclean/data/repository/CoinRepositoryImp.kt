package com.example.cryptoclean.data.repository

import com.example.cryptoclean.data.remote.CoinApi
import com.example.cryptoclean.data.remote.dto.CoinDto
import com.example.cryptoclean.domain.repository.CoinRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(private val api: CoinApi) : CoinRepository {


    override fun getCoins(): Single<List<CoinDto>> {
        return api.getCoins()
    }
}