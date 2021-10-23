package com.epam.spacex.data.remote.dto.note

import com.squareup.moshi.Json

data class NoteRequestDto(
    @Json(name = "title")
    val name: String = ""
)