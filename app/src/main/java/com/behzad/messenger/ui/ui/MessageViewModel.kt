package com.behzad.messenger.ui.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.behzad.messenger.databse.AppDatabase
import com.behzad.messenger.databse.Message
import kotlinx.coroutines.launch

class MessageViewModel(application: Application) : AndroidViewModel(application) {
    private val messageDao = AppDatabase.getInstance(application).messageDao()

    val allMessages: LiveData<List<Message>> = messageDao.getAllMessages()

    fun insertMessage(message: Message) {
        viewModelScope.launch {
            messageDao.insert(message)
        }
    }
}
