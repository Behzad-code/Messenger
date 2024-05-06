package com.behzad.messenger.databse

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "phoneNumber")
    var phoneNumber: String,
    @ColumnInfo(name = "messageContent")
    var messageContent: String
)



