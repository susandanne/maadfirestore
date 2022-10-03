package com.example.maadfirestore.di

import com.example.maadfirestore.data.repositories.NoteRepository
import com.example.maadfirestore.data.repositories.NoteRepositoryImpl
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object repositoeisemodule {



    @Provides
    @Singleton
    fun providenoterepo(database:FirebaseFirestore):NoteRepository{

        return NoteRepositoryImpl(database)
    }
}