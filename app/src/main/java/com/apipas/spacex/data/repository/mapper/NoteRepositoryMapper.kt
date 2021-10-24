package com.apipas.spacex.data.repository.mapper

import com.apipas.spacex.data.model.Note
import com.apipas.spacex.data.remote.dto.note.NoteResponseDto

object NoteRepositoryMapper {
    fun convert(data: NoteResponseDto): Note = Note(data.id, data.title)

    fun convert(data: List<NoteResponseDto>): List<Note> =
        data.map { convert(it) }.toList()
}