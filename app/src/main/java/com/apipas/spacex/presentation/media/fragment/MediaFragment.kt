package com.apipas.spacex.presentation.media.fragment

import com.apipas.spacex.R
import com.apipas.spacex.databinding.FragmentFilterBinding
import com.apipas.spacex.databinding.FragmentMediaBinding
import com.apipas.spacex.presentation.base.fragment.BaseFragment
import com.apipas.spacex.presentation.filter.viewmodel.FilterViewModel
import com.apipas.spacex.presentation.media.viewmodel.MediaViewModel

internal class MediaFragment : BaseFragment<FragmentMediaBinding, MediaViewModel>(
    R.layout.fragment_media,
    MediaViewModel::class
)