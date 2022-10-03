package com.example.maadfirestore.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object firebasemodule {



    @Provides
    @Singleton
    fun providesfirestore():FirebaseFirestore{


        return FirebaseFirestore.getInstance()
    }

}