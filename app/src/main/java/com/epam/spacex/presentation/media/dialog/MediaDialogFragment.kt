package com.epam.spacex.presentation.media.dialog

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.epam.spacex.R
import com.epam.spacex.databinding.DialogMediaBinding
import com.epam.spacex.presentation.base.dialog.BaseBottomSheetDialogFragment
import com.epam.spacex.presentation.base.event.common.OpenWebEvent
import com.epam.spacex.presentation.base.event.common.OpenYoutubeEvent
import com.epam.spacex.presentation.media.viewmodel.MediaViewModel
import com.epam.spacex.util.IntentUtil

internal class MediaDialogFragment :
    BaseBottomSheetDialogFragment<DialogMediaBinding, MediaViewModel>(
        R.layout.dialog_media,
        MediaViewModel::class
    ) {
    private val args: MediaDialogFragmentArgs by navArgs()

    override fun initVM() {
        viewModel.add(args.homeLaunchItemModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        subscribe(OpenWebEvent::class, Observer { event ->
            requireActivity().startActivity(IntentUtil.openWebIntent(event.url))
        })

        subscribe(OpenYoutubeEvent::class, Observer { event ->
            requireActivity().startActivity(IntentUtil.openYouTube(event.id))
        })
    }
}