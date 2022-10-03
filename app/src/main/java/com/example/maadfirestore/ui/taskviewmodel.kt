package com.example.maadfirestore.ui

import androidx.lifecycle.ViewModel
import com.example.maadfirestore.data.model.Note
import com.example.maadfirestore.data.repositories.NoteRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class taskviewmodel @Inject constructor(var repositoryImpl: NoteRepositoryImpl): ViewModel() {

    fun add(note: Note)=repositoryImpl.add(note)
    fun getAllTask()=repositoryImpl.getAllTask()
    val allNotes=repositoryImpl.allNotes

}