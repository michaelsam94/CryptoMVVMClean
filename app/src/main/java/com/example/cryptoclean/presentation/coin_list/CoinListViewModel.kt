package com.example.cryptoclean.presentation.coin_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoclean.common.Resource
import com.example.cryptoclean.domain.model.Coin
import com.example.cryptoclean.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) :
    ViewModel() {
    private val _state = MutableLiveData<Resource<List<Coin>>>()
    val state: LiveData<Resource<List<Coin>>> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        _state.value = Resource.Loading()
        getCoinsUseCase.execute({
            _state.value = Resource.Success(it)
        }, {
            _state.value = Resource.Error(message = it.localizedMessage ?: "unexpected error")
        })
    }
}