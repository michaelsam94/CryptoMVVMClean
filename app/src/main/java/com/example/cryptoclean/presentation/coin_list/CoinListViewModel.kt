package com.example.cryptoclean.presentation.coin_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoclean.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) :
    ViewModel() {
    private val _state = MutableLiveData<CoinListState>()
    val state: LiveData<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        _state.value = CoinListState(true)
        getCoinsUseCase.execute({
            _state.value = CoinListState(false, it)
        }, {
            _state.value =
                CoinListState(isLoading = false, error = it.localizedMessage ?: "unexpected error")
        })
    }
}