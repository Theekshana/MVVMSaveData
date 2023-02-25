package com.example.filesave

import android.content.Context
import java.io.File

class FileSaver(context: Context) {

    private val context = context
    private val fileName = "data.txt"

    fun writeToFile(dataToSave: String) {

        context.openFileOutput(fileName, Context.MODE_PRIVATE).use {
            it.write(dataToSave.toByteArray())
        }


    }

    fun readFromFile(): String {

        val readStr = File(context.filesDir, fileName).readText()
        return readStr


    }
}










