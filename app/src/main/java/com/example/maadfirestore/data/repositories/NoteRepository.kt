package com.example.maadfirestore.data.repositories


import com.example.maadfirestore.data.model.Note
import com.example.maadfirestore.utils.UiState


interface NoteRepository {
    fun add(note: Note)
    fun update(note: Note)


    fun getAllTask()
    fun delete()
}