package com.apipas.spacex.presentation.home

import com.apipas.spacex.R
import com.apipas.spacex.databinding.FragmentHomeBinding
import com.apipas.spacex.presentation.base.fragment.MvvmFragment
import com.apipas.spacex.presentation.home.viewmodel.HomeViewModel

class HomeFragment : MvvmFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home,
    HomeViewModel::class
){

}