package com.example.maadfirestore.utils



sealed class UiState<T>(val data:T?=null,val message:String?=null) {

    class loading<T>():UiState<T>()
    class success<T>(data:T?=null,message: String):UiState<T>(data,message)
    class failure<T>(data:T?=null,message: String):UiState<T>( data,message)
}