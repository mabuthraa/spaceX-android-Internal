package com.epam.spacex.presentation.filter.dialog

import com.epam.spacex.R
import com.epam.spacex.databinding.DialogFilterBinding
import com.epam.spacex.presentation.base.dialog.BaseBottomSheetDialogFragment
import com.epam.spacex.presentation.filter.viewmodel.FilterViewModel

internal class FilterDialogFragment :
    BaseBottomSheetDialogFragment<DialogFilterBinding, FilterViewModel>(
        R.layout.dialog_filter,
        FilterViewModel::class
    )