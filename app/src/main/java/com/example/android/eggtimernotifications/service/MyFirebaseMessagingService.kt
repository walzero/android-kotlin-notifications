package com.example.android.eggtimernotifications.service

import android.util.Log
import androidx.core.content.ContextCompat
import com.example.android.eggtimernotifications.extensions.notificationManager
import com.example.android.eggtimernotifications.util.sendNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d("FCMMESSAGE", "From ${remoteMessage.from}")

        remoteMessage.data
            .takeIf { it.isNotEmpty() }
            .run { Log.d("FCMMESSAGE", "Message data payload: $this") }

        remoteMessage.notification?.let {
            Log.d("FCMMESSAGE", "Message notification body: ${it.body}")
            sendNotification(it.body!!)
        }
    }

    private fun sendNotification(messageBody: String) {
        with(applicationContext) {
            notificationManager().sendNotification(messageBody, this)
        }
    }

    override fun onNewToken(newToken: String) {
        Log.d("FCMTOKEN", "Refreshed token: $newToken")
        sendRegistrationToServer(newToken)
    }

    private fun sendRegistrationToServer(newToken: String) {
        TODO("Not yet implemented")
    }
}