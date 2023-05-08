package com.example.notepad.extensions

import android.app.Activity
import android.content.Context
import com.example.notepad.constant.Constant

fun Activity.updateTheFirstTimeLaunchApp(){
    val sharedPreference =  this.getSharedPreferences(Constant.MAIN_SHARE_PREFERENCE, Context.MODE_PRIVATE)
    val editor = sharedPreference.edit()
    editor.putBoolean(Constant.IS_FIRST_LAUNCH, true)
    editor.commit()
}

fun Activity.updateTheFirstTimeAddNote(){
    val sharedPreference =  this.getSharedPreferences(Constant.MAIN_SHARE_PREFERENCE, Context.MODE_PRIVATE)
    val editor = sharedPreference.edit()
    editor.putBoolean(Constant.IS_FIRST_ADDED, true)
    editor.commit()
}