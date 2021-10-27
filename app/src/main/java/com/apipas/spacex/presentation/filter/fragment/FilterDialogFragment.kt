package com.apipas.spacex.presentation.filter.fragment

import android.os.Bundle
import android.view.View
import com.apipas.spacex.R
import com.apipas.spacex.databinding.DialogFilterBinding
import com.apipas.spacex.presentation.base.dialog.BaseBottomSheetDialogFragment
import com.apipas.spacex.presentation.filter.viewmodel.FilterViewModel
import com.apipas.spacex.util.extension.toHtml

internal class FilterDialogFragment :
    BaseBottomSheetDialogFragment<DialogFilterBinding, FilterViewModel>(
        R.layout.dialog_filter,
        FilterViewModel::class
    )