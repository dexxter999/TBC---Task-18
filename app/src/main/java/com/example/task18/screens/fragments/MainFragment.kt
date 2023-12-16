package com.example.task18.screens.fragments

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.task18.adapter.PersonsRecyclerViewAdapter
import com.example.task18.base.BaseFragment
import com.example.task18.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()
    private val adapter: PersonsRecyclerViewAdapter by lazy { PersonsRecyclerViewAdapter() }
    override fun init() {
        binding.recyclerView.apply {
            adapter = this@MainFragment.adapter
        }
        loadData()
    }

    private fun loadData() {
        lifecycleScope.launch {
            viewModel.personsList.collectLatest {
                binding.apply {
                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                }
                adapter.submitData(it)
            }
        }
    }

}