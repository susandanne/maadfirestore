package com.example.maadfirestore.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.maadfirestore.data.model.Note
import com.example.maadfirestore.utils.constants
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(val database:FirebaseFirestore) : NoteRepository{


    override fun add(note: Note) {
        val document = database.collection(constants.NOTE).document()

        note.id = document.id
        document.set(note).addOnSuccessListener {

        }.addOnFailureListener {

        }
    }
    val allNotes = MutableLiveData<List<Note>>()
    override fun getAllTask() {
       val notes=ArrayList<Note>()
       database.collection(constants.NOTE)
           .get()
           .addOnSuccessListener {
          for (documnet in it){
              val note=documnet.toObject(Note::class.java)
           notes.add(note)
          }
               allNotes.value=notes
           }
           .addOnFailureListener {

           }

    }

}