package com.apipas.spacex.presentation.notelist

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.apipas.spacex.app.SpaceXApp
import com.apipas.spacex.R
import com.apipas.spacex.data.model.Note
import com.apipas.spacex.data.remote.client.api.ApiResult
import com.apipas.spacex.data.repository.NoteRepository
import com.apipas.spacex.presentation.base.viewmodel.BaseViewModel
import com.apipas.spacex.util.DateTimeFormat
import java.util.*

class NoteListVM(private val noteRepository: NoteRepository) : BaseViewModel() {
    val notes = ObservableArrayList<Note>()
    val lastUpdate = MutableLiveData<String>().apply { value = "" }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onResume() {
        launchDataLoad {
            notes.clear()
            //load all
            when (val res = noteRepository.getNotes()) {
                is ApiResult.Success -> notes.addAll(res.apiData)
                is ApiResult.Error -> throw res.exception
            }
            val formattedDate = DateTimeFormat.formatTimeDate(Date())
            lastUpdate.value = SpaceXApp.instance.getString(R.string.note_list_last_update, formattedDate)
        }
    }

    fun goToNoteDetail(id: String? = null, editMode: Boolean = false) {
        publish(NavToNoteDetailEvent(id, editMode))
    }
}