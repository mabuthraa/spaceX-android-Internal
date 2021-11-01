package com.epam.spacex.presentation.home.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.annotation.ColorInt
import com.epam.spacex.R
import com.epam.spacex.databinding.FragmentHomeBinding
import com.epam.spacex.presentation.base.fragment.BaseFragment
import com.epam.spacex.presentation.filter.viewmodel.FilterViewModel
import com.epam.spacex.presentation.home.viewmodel.HomeViewModel
import com.epam.spacex.util.ColorUtil
import org.koin.androidx.viewmodel.ext.android.sharedStateViewModel

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
        @ColorInt val color = ColorUtil.getColorFromTheme(
            requireContext(),
            R.attr.colorSecondary,
            requireContext().resources.getColor(R.color.tiffany_blue_500)
        )
        binding.homeRefreshLayout.setColorSchemeColors(color)
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