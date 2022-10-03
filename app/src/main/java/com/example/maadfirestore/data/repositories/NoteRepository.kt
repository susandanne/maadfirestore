package com.example.maadfirestore.data.repositories


import com.example.maadfirestore.data.model.Note


interface NoteRepository {
    fun add(note: Note)

    fun getAllTask()
}