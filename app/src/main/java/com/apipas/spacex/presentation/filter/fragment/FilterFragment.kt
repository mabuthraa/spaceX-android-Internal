package com.apipas.spacex.presentation.filter.fragment

import com.apipas.spacex.R
import com.apipas.spacex.databinding.FragmentFilterBinding
import com.apipas.spacex.presentation.base.fragment.BaseFragment
import com.apipas.spacex.presentation.filter.viewmodel.FilterViewModel

internal class FilterFragment : BaseFragment<FragmentFilterBinding, FilterViewModel>(
    R.layout.fragment_filter,
    FilterViewModel::class
)