package com.qwqeqrqwqeqr.sensor.util

import android.content.Context
import android.os.Environment

object FileUtils {

    val Context.getFilePath: String
        get() = filesDir.toString()

    fun getExternalFilePath(): String =  Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()
}