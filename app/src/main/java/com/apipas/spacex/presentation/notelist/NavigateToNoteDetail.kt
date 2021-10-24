package com.apipas.spacex.presentation.notelist

import com.apipas.spacex.presentation.base.event.common.LiveEvent

class NavToNoteDetailEvent(val idNote: String?, val editMode: Boolean = false) : LiveEvent()