package com.miu.cvbuilder.views.other

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GetInTouchFragmentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Get In Touch Fragment"
    }
    val text: LiveData<String> = _text
}