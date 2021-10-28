package com.apipas.spacex.presentation.home.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.apipas.spacex.R
import com.apipas.spacex.databinding.FragmentHomeBinding
import com.apipas.spacex.presentation.base.fragment.BaseFragment
import com.apipas.spacex.presentation.filter.viewmodel.FilterViewModel
import com.apipas.spacex.presentation.home.viewmodel.HomeViewModel
import com.apipas.spacex.util.Log
import org.koin.androidx.viewmodel.ext.android.sharedStateViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home,
    HomeViewModel::class
) {
    private val filterViewModel by sharedStateViewModel<FilterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeRefreshLayout.setColorSchemeResources(R.color.accent)
        initObservers()
    }

    private fun initObservers() {
        filterViewModel.filterModel.yearRange.observe(viewLifecycleOwner, {
            viewModel.updateQuery(filterViewModel.filterModel)
        })

        filterViewModel.filterModel.sortModel.observe(viewLifecycleOwner, {
            viewModel.updateQuery(filterViewModel.filterModel)
        })

        filterViewModel.filterModel.onlyLaunchesModel.observe(viewLifecycleOwner, {
            viewModel.updateQuery(filterViewModel.filterModel)
        })
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