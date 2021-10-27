package com.apipas.spacex.presentation.filter.dialog

import com.apipas.spacex.R
import com.apipas.spacex.databinding.DialogFilterBinding
import com.apipas.spacex.presentation.base.dialog.BaseBottomSheetDialogFragment
import com.apipas.spacex.presentation.filter.viewmodel.FilterViewModel

internal class FilterDialogFragment :
    BaseBottomSheetDialogFragment<DialogFilterBinding, FilterViewModel>(
        R.layout.dialog_filter,
        FilterViewModel::class
    )