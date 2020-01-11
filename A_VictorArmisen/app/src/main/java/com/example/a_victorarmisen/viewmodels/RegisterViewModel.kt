package com.example.a_victorarmisen.viewmodels

import androidx.lifecycle.MutableLiveData

class RegisterViewModel
{

    public val isUserCreated = MutableLiveData<Boolean>().apply { value = false}

    fun isUsernameValid(username: String): Boolean {
        return username.isNotBlank()
    }

    //Email is valid
    //Password is valid: Pasar el codigo de signup password aqui

}




