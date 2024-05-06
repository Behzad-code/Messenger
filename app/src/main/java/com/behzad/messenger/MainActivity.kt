package com.behzad.messenger


import android.content.Context
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.behzad.messenger.ui.theme.MessengerTheme
import com.behzad.messenger.ui.theme.greenColor


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            MessengerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "GFG",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center,
                                        color = Color.White
                                    )
                                })
                        }) {
                        SmsUI(context = LocalContext.current)
                    }
                }
            }
        }
    }
}

@Composable
fun SmsUI(context: Context) {

    val phoneNumber = remember {
        mutableStateOf("")
    }
    val message = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(

            text = "SMS Manager in Android",

            color = greenColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        TextField(
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },

            placeholder = { Text(text = "Enter your phone number") },

            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(

            value = message.value,

            onValueChange = { message.value = it },

            placeholder = { Text(text = "Enter your message") },

            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            singleLine = true,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            try {

                val smsManager: SmsManager = SmsManager.getDefault()

                smsManager.sendTextMessage(phoneNumber.value, null, message.value, null, null)

                Toast.makeText(
                    context,
                    "Message Sent",
                    Toast.LENGTH_LONG
                ).show()
            } catch (e: Exception) {

                Toast.makeText(
                    context,
                    "Error : " + e.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }) {

            Text(
                text = "Send SMS",
                modifier = Modifier.padding(10.dp),
                color = Color.White,
                fontSize = 15.sp
            )
        }
    }
}
