package com.miu.cvbuilder.views.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _mainText = MutableLiveData<String>().apply {
        value = "Home Fragment"
    }
    val mainText: LiveData<String> = _mainText
}