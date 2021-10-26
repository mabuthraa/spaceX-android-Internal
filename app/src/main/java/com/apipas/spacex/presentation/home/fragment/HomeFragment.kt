package com.apipas.spacex.presentation.home.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.apipas.spacex.R
import com.apipas.spacex.databinding.FragmentHomeBinding
import com.apipas.spacex.presentation.base.fragment.BaseFragment
import com.apipas.spacex.presentation.home.viewmodel.HomeViewModel
import com.apipas.spacex.util.Log

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home,
    HomeViewModel::class
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_filter -> {
                viewModel.onFilterClick()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}