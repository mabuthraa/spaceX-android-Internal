package com.apipas.spacex.presentation.media.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apipas.spacex.presentation.base.event.common.GoToEvent
import com.apipas.spacex.presentation.base.event.common.OpenWebEvent
import com.apipas.spacex.presentation.base.event.common.OpenYoutubeEvent
import com.apipas.spacex.presentation.base.viewmodel.BaseViewModel
import com.apipas.spacex.presentation.home.fragment.HomeFragmentDirections
import com.apipas.spacex.presentation.home.model.HomeLaunchItemModel

class MediaViewModel() : BaseViewModel() {

    private val _links = MutableLiveData<HomeLaunchItemModel.Links?>()
    val links: LiveData<HomeLaunchItemModel.Links?> get() = _links

    private val _imageUrl = MutableLiveData<String?>()
    val imageUrl: LiveData<String?> get() = _imageUrl

    fun add(model: HomeLaunchItemModel) {
        _links.value = model.links
        _imageUrl.value = model.imageUrl
    }

    fun openYoutube(id: String) {
        publish(OpenYoutubeEvent(id))
    }

    fun openWeb(ur: String) {
        publish(OpenWebEvent(ur))
    }
}