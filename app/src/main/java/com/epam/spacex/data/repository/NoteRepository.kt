package com.epam.spacex.data.repository

import com.epam.spacex.data.model.Note
import com.epam.spacex.data.remote.client.api.ApiResult
import com.epam.spacex.data.remote.client.api.safeApiCall
import com.epam.spacex.data.remote.dto.note.NoteRequestDto
import com.epam.spacex.data.remote.service.NoteServiceApi
import com.epam.spacex.data.repository.mapper.NoteRepositoryMapper
import com.epam.spacex.data.exception.RepositoryException

interface NoteRepository {
    suspend fun getNotes(): ApiResult<List<Note>>
    suspend fun getNote(id: String): ApiResult<Note>
    suspend fun createNote(title: String): ApiResult<Note>
    suspend fun updateNote(id: String, title: String): ApiResult<Note>
    suspend fun deleteNote(id: String): ApiResult<Unit>
}

class NoteRepositoryImp(private val service: NoteServiceApi) :
    NoteRepository {

    override suspend fun getNotes(): ApiResult<List<Note>> {
        return safeApiCall(
            { service.getNotesAsync().await() },
            mapper = NoteRepositoryMapper::convert
        )
    }

    override suspend fun getNote(id: String): ApiResult<Note> {
        return safeApiCall(
            { service.getNoteAsync(id).await() },
            mapper = NoteRepositoryMapper::convert
        )
    }

    override suspend fun createNote(title: String): ApiResult<Note> {
        val resDto = NoteRequestDto(title)
        val result = safeApiCall(
            { service.createNotesAsync(resDto).await() },
            mapper = NoteRepositoryMapper::convert
        )
        return when (result) {
            is ApiResult.Success -> {
                if (result.res?.code() == 201) {
                    ApiResult.Success(result.apiData)
                } else {
                    ApiResult.Error(RepositoryException())
                }
            }
            is ApiResult.Error -> ApiResult.Error(result.exception)
        }
    }

    override suspend fun updateNote(id: String, title: String): ApiResult<Note> {
        val resDto = NoteRequestDto(title)
        val result = safeApiCall(
            { service.updateNotAsync(id, resDto).await() },
            mapper = NoteRepositoryMapper::convert
        )
        return when (result) {
            is ApiResult.Success -> {
                if (result.res?.code() == 201) {
                    ApiResult.Success(result.apiData)
                } else {
                    ApiResult.Error(RepositoryException())
                }
            }
            is ApiResult.Error -> ApiResult.Error(result.exception)
        }
    }

    override suspend fun deleteNote(id: String): ApiResult<Unit> {
        val result =
            safeApiCall({ service.deleteAsync(id).await() }, mapper = fun(_) { return Unit })
        return when (result) {
            is ApiResult.Success -> {
                if (result.res?.code() == 204) {
                    ApiResult.Success(result.apiData)
                } else {
                    ApiResult.Error(RepositoryException())
                }
            }
            is ApiResult.Error -> ApiResult.Error(result.exception)
        }
    }
}