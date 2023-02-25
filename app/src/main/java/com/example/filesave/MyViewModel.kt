package com.example.filesave

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val _savedText = MutableLiveData<String>(null)

    val savedText: LiveData<String>
        get() = _savedText

    fun saveText(savedText: String) {
        _savedText.value = savedText
    }

}