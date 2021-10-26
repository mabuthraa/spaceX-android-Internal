package com.apipas.spacex.presentation.base.event.common

import androidx.navigation.NavDirections
import com.apipas.spacex.presentation.base.event.base.LiveEvent

class GoToEvent(val direction: NavDirections) : LiveEvent()