package com.epam.spacex.presentation.notelist

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.epam.spacex.app.SpaceXApp
import com.epam.spacex.R
import com.epam.spacex.data.model.Note
import com.epam.spacex.data.remote.client.api.ApiResult
import com.epam.spacex.data.repository.NoteRepository
import com.epam.spacex.presentation.base.BaseViewModel
import com.epam.spacex.util.DateTimeFormat
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