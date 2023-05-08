package com.example.notepad.extensions

import android.app.Activity
import android.content.Intent
import android.os.Build
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun Activity.getCurrentTime(): String{
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
    return current.format(formatter)
}

fun Activity.intentTo(activity: Activity){
    startActivity(Intent(this, Activity::class.java))
}