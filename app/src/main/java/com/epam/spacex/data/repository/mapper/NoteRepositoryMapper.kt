package com.epam.spacex.data.repository.mapper

import com.epam.spacex.data.model.Note
import com.epam.spacex.data.remote.dto.note.NoteResponseDto

object NoteRepositoryMapper {
    fun convert(data: NoteResponseDto): Note = Note(data.id, data.title)

    fun convert(data: List<NoteResponseDto>): List<Note> =
        data.map { convert(it) }.toList()
}