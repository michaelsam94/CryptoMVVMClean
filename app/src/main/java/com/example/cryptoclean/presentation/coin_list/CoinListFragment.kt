package com.example.cryptoclean.presentation.coin_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoclean.databinding.FragmentCoinListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinListFragment : Fragment() {

    private val viewModel: CoinListViewModel by viewModels()
    private lateinit var binding: FragmentCoinListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(requireActivity(), {
            if (it.isLoading) Toast.makeText(requireContext(), "Loading...", Toast.LENGTH_SHORT)
                .show()
            if (it.coins.isNotEmpty())
                with(binding.rvCoins) {
                    adapter = CoinsAdapter(it.coins)
                    layoutManager = LinearLayoutManager(requireContext())
                }

            if (it.error.isNotEmpty()) Toast.makeText(
                requireContext(),
                it.error,
                Toast.LENGTH_SHORT
            ).show()
        })
    }

}