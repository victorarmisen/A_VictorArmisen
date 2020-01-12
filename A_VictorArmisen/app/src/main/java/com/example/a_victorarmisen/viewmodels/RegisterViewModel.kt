package com.example.a_victorarmisen.viewmodels

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import com.example.a_victorarmisen.activity.MainActivity
import com.example.a_victorarmisen.model.UserModel
import com.example.a_victorarmisen.util.UserMode
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterViewModel
{

    public val isUserCreated = MutableLiveData<Boolean>().apply { value = false}
    val error = MutableLiveData<String?>().apply { value = null }



    fun isUsernameValid(username: String): Boolean {
        return username.isNotBlank()
    }

    //Email is valid
    //Password is valid: Pasar el codigo de signup password aqui

    fun createUser(username: String, email:String,password:String)
    {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { AuthResult ->
                    //if (AuthResult.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Sign", "createUserWithEmail:success")
                        val user = FirebaseAuth.getInstance().currentUser
                        val userModel =
                                UserMode(
                                        user?.uid,
                                        username,
                                        email
                                )

                        val db = FirebaseFirestore.getInstance()
                        //  if (user != null) {

                        if (user != null) {
                            db.collection("users")
                                    .document(user.uid)
                                    .set(userModel)
                                    .addOnSuccessListener {
                                        // Sign Up Completed!
                                        isUserCreated.postValue(true)
                                        Log.e("SignUpActivity", "user everything was fine and finish!")
                                        //startActivity(Intent(this, MainActivity::class.java))

                                    }.addOnFailureListener {
                                        Log.e("SignUpActivity", it.message)
                                        error.postValue(it.localizedMessage)

                                    }
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("SignUp", "createUserWithEmail:failure", AuthResult.exception)
                            //Toast.makeText(this@, "Authentication failed.", Toast.LENGTH_SHORT).show()

                        }






                    // ...
                }





    }

}




