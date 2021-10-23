package com.epam.spacex.ui.notelist

import com.epam.spacex.event.common.LiveEvent

class NavToNoteDetailEvent(val idNote: String?, val editMode: Boolean = false) : LiveEvent()