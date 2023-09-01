package com.lixiang.phonecall.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*


fun String.log(tag:String="qwer"){
    Log.e(tag,this)
}

fun Context.toast(string: String){
    Toast.makeText(this,string,Toast.LENGTH_LONG).show()
}

//fun isReferBuyUser(string: String)=string.contains("fb4a")||string.contains("gclid")||string.contains("not%20set")
//        ||string.contains("youtubeads")||string.contains("%7B%22")
//
//fun isFBUser(string: String)=string.contains("fb4a")

fun isAdJustBuyUser(string: String)=!string.contains("organic")

fun isCloakUser(string: String)=string=="alison"


fun adShowNumKey(key:String)="${SimpleDateFormat("yyyy-MM-dd").format(Date(System.currentTimeMillis()))}_${key}"

fun Activity.toSetting(){
    startActivity(Intent(Settings.ACTION_SETTINGS))
}
