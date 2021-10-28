package com.apipas.spacex.presentation.media.dialog

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.apipas.spacex.R
import com.apipas.spacex.databinding.DialogMediaBinding
import com.apipas.spacex.presentation.base.dialog.BaseBottomSheetDialogFragment
import com.apipas.spacex.presentation.base.event.common.OpenWebEvent
import com.apipas.spacex.presentation.base.event.common.OpenYoutubeEvent
import com.apipas.spacex.presentation.media.viewmodel.MediaViewModel
import com.apipas.spacex.util.IntentUtil

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