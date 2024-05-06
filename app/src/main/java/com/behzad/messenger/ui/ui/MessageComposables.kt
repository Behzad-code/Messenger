package com.behzad.messenger.ui.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.behzad.messenger.databse.Message

@Composable
fun MessageItem(message: Message) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Title: ${message.title}", fontWeight = FontWeight.Bold)
        Text(text = "Phone Number: ${message.phoneNumber}")
        Text(text = "Message Content: ${message.messageContent}")
        Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(vertical = 4.dp))
    }
}

@Composable
fun MessageList(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageItem(message = message)
        }
    }
}
