package com.epam.spacex.presentation.notelist

import com.epam.spacex.presentation.base.event.common.LiveEvent

class NavToNoteDetailEvent(val idNote: String?, val editMode: Boolean = false) : LiveEvent()