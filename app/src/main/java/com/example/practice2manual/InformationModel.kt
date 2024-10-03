package com.example.practice2manual

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InformationModel : ViewModel() {
    val email : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val username : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val dateOfBirth : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}