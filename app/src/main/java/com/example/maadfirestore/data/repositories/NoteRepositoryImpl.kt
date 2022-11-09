package com.example.maadfirestore.data.repositories

import android.os.Message
import android.provider.Contacts.Intents.UI
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.maadfirestore.data.model.Note
import com.example.maadfirestore.utils.UiState
import com.example.maadfirestore.utils.constants
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(val database:FirebaseFirestore) : NoteRepository{

   private val _createresponse=MutableLiveData<UiState<String>>()
    val createresponse:LiveData<UiState<String>>
    get() = _createresponse




    override fun add(note: Note) {
        _createresponse.postValue(UiState.loading())

        val document = database.collection(constants.NOTE).document()

        note.id = document.id
        document.set(note).addOnSuccessListener {
      _createresponse.postValue(UiState.success("","nice to meet you"))
        }.addOnFailureListener {
       _createresponse.postValue(UiState.failure(message = it.localizedMessage))
        }
    }



    private val _alltask=MutableLiveData<UiState<List<Note>>>()
   val alltask:LiveData<UiState<List<Note>>>
   get ()=_alltask

    val allNotes = MutableLiveData<List<Note>>()
    override fun getAllTask() {
       val notes1=ArrayList<Note>()
        _alltask.postValue(UiState.loading())
       database.collection(constants.NOTE)
           .get()
           .addOnSuccessListener {
          for (document1 in it){
              val note=document1.toObject(Note::class.java)
           notes1.add(note)
          }
               _alltask.postValue(UiState.success(notes1,""))
           }
           .addOnFailureListener {
        _alltask.postValue(UiState.failure(message = it.localizedMessage))
        }
           }


    override fun update(note: Note) {

    }
    override fun delete() {
        val document = database.collection(constants.NOTE).document(
        )

        document.delete().addOnSuccessListener {
//            _createresponse.postValue(UiState.success("","nice to meet you"))
        }.addOnFailureListener {
//            _createresponse.postValue(UiState.failure(message = it.localizedMessage))
        }
    }

}

