package com.epam.spacex.presentation.home

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.epam.spacex.data.repository.NoteRepository
import com.epam.spacex.presentation.base.BaseViewModel

class HomeVM(private val noteRepository: NoteRepository) : BaseViewModel() {
//    val notes = ObservableArrayList<Note>()
//    val lastUpdate = MutableLiveData<String>().apply { value = "" }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate() {
        launchDataLoad {
//            notes.clear()
//            //load all
//            when (val res = noteRepository.getNotes()) {
//                is ApiResult.Success -> notes.addAll(res.apiData)
//                is ApiResult.Error -> throw res.exception
//            }
//            val formattedDate = DateTimeFormat.formatTimeDate(Date())
//            lastUpdate.value = App.instance.getString(R.string.note_list_last_update, formattedDate)
        }
    }

//    fun goToNoteDetail(id: String? = null, editMode: Boolean = false) {
//        publish(NavToNoteDetailEvent(id, editMode))
//    }
}