package com.epam.spacex.presentation.base.event.common

import androidx.navigation.NavDirections
import com.epam.spacex.presentation.base.event.base.LiveEvent

class GoToEvent(val direction: NavDirections) : LiveEvent()