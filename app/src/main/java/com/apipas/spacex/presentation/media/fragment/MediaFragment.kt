package com.apipas.spacex.presentation.media.fragment

import android.os.Bundle
import com.apipas.spacex.R
import com.apipas.spacex.databinding.DialogMediaBinding
import com.apipas.spacex.presentation.base.dialog.BaseBottomSheetDialogFragment
import com.apipas.spacex.presentation.media.viewmodel.MediaViewModel

internal class MediaDialogFragment :
    BaseBottomSheetDialogFragment<DialogMediaBinding, MediaViewModel>(
        R.layout.dialog_media,
        MediaViewModel::class
    ) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}