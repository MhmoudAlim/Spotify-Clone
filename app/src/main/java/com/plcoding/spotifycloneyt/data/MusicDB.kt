package com.plcoding.spotifycloneyt.data

import com.google.firebase.firestore.FirebaseFirestore
import com.plcoding.spotifycloneyt.data.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDB {
    private val fireStore = FirebaseFirestore.getInstance()
    private val songCollections = fireStore.collection(SONG_COLLECTION)


    suspend fun getAllSongs() : List<Song>{
        return try {
            songCollections.get().await().toObjects(Song::class.java)
        }catch (e: Exception){
            emptyList()
        }
    }
}