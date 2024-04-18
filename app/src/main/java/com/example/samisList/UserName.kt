package com.example.littlelemon

object UserName {
var theName : String = "User"

    fun setUserName(newName: String) {
        theName= newName // This updates the LiveData's value
    }
    fun getUserName(): String {
      return  theName
    }
}