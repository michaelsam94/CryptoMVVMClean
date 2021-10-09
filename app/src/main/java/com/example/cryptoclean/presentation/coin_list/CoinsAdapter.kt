package com.example.cryptoclean.presentation.coin_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoclean.databinding.ItemCoinBinding
import com.example.cryptoclean.domain.model.Coin

class CoinsAdapter(private val coins: List<Coin>) : RecyclerView.Adapter<CoinsAdapter.CoinVH>() {


    inner class CoinVH(private val binding: ItemCoinBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(coin: Coin) {
            binding.tvCoinName.text = coin.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinVH {
        return CoinVH(ItemCoinBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CoinVH, position: Int) {
        holder.bindView(coins[position])
    }

    override fun getItemCount(): Int {
        return coins.size
    }
}