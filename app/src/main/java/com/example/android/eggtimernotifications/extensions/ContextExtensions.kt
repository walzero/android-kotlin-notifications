package com.example.android.eggtimernotifications.extensions

import android.app.NotificationManager
import android.content.Context
import androidx.core.content.ContextCompat

fun Context.notificationManager(): NotificationManager {
    return ContextCompat.getSystemService(
        this,
        NotificationManager::class.java
    ) as NotificationManager
}