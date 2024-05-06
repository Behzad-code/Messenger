package com.behzad.messenger.databse

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MessageDao {
    @Insert
    fun insert(message: Message)

    @Query("SELECT * FROM messages")
    fun getAllMessages(): LiveData<List<Message>>
}

