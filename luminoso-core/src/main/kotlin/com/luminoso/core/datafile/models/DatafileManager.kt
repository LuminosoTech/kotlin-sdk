package com.luminoso.core.datafile.models

interface DatafileUpdateListener {
    fun onUpdate(datafileUpdate: String)
}

interface DatafileManager {
    fun get(): String
    fun on(eventName: String, listener: DatafileUpdateListener): () -> Unit
    fun onReady(): () -> Unit
}