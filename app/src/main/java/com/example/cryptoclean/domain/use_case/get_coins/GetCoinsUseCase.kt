package com.example.cryptoclean.domain.use_case.get_coins

import com.example.cryptoclean.data.remote.dto.toCoin
import com.example.cryptoclean.domain.model.Coin
import com.example.cryptoclean.domain.repository.CoinRepository
import com.example.cryptoclean.domain.use_case.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repo: CoinRepository) :
    SingleUseCase<List<Coin>>() {

    override fun buildUseCaseSingle(): Single<List<Coin>> {
        return repo.getCoins().map { coinDtos -> coinDtos.map { it.toCoin() } }
    }
}