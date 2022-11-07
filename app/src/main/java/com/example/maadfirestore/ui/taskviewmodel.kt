package com.example.maadfirestore.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maadfirestore.data.model.Note
import com.example.maadfirestore.data.repositories.NoteRepositoryImpl
import com.example.maadfirestore.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class taskviewmodel @Inject constructor(var repositoryImpl: NoteRepositoryImpl): ViewModel() {
//    val allNotes= MutableLiveData<UiState<List<Note>>>()
    fun addnote(note: Note)=repositoryImpl.add(note)
    val creeteresponse=repositoryImpl.createresponse

    fun getAllTask()=repositoryImpl.getAllTask()

    val alltask=repositoryImpl.alltask


}