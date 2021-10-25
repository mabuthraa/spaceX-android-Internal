package com.apipas.spacex.presentation.home

import com.apipas.spacex.R
import com.apipas.spacex.databinding.FragmentHomeBinding
import com.apipas.spacex.presentation.base.fragment.BaseFragment
import com.apipas.spacex.presentation.home.viewmodel.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home,
    HomeViewModel::class
)