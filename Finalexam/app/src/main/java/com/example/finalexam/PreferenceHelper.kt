package com.example.finalexam

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {

    private lateinit var sharedPref: SharedPreferences
    private lateinit var editPref:SharedPreferences.Editor
    private const val MODE = Context.MODE_PRIVATE
    private const val PREF_NAME = "Game"

    fun init(context:Context){
        sharedPref = context.getSharedPreferences(PREF_NAME, MODE)
        editPref = sharedPref.edit()
    }

    fun clearAllPref(){
        editPref.clear()
        editPref.apply()
    }

    fun writeStringPref(key:String,value:String){
        editPref.putString(key,value)
        editPref.apply()
    }

    fun readStringPref(key:String):String? {
        return sharedPref.getString(key,"")
    }

    fun writeIntPref(key:String,value:Int){
        editPref.putInt(key,value)
        editPref.apply()
    }

    fun readIntPref(key:String):Int {
        return sharedPref.getInt(key,0)
    }
}
