package com.example.littlelemon

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    var userName = mutableStateOf("")
        private set

    fun updateUserName(newName: String) {
        userName.value = newName
    }
}
