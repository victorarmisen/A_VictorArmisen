package com.example.a_victorarmisen.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import com.example.a_victorarmisen.R
import com.example.a_victorarmisen.fragment.ProfileFragment
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FacebookAuthProvider
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_log_in.button_facebook
import kotlinx.android.synthetic.main.activity_sign_up.*

class LogIn : AppCompatActivity() {

    private lateinit var user_result  : String
    private lateinit var mail_result  : String
    private lateinit var auth: FirebaseAuth
    private lateinit var callbackManager: CallbackManager


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val db = FirebaseFirestore.getInstance()

        //val buttonLOG_OUT = findViewById(R.id.LOG_OUT) as Button
        //val username = findViewById(R.id.Username_LogIn) as TextView
        //val mail = findViewById(R.id.Mail_LogIn) as TextView
        //val eEmail = findViewById<EditText>(R.id.mail_current) as EditText;
        val user = FirebaseAuth.getInstance().currentUser
        auth = FirebaseAuth.getInstance()

/*
        if (user != null)
        {

            val username_collection = db.collection("users").document(user.uid).get()

            val editor = this.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE).edit()
            //val username2 = eEmail.getText().toString()

            editor.putString(PREF_USERID, user.uid)
            editor.putString(PREF_USERNAME, username_collection.toString())

            val userPreferences = this?.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)
            val userId = userPreferences?.getString(PREF_USERID, "")
            val username_string = userPreferences?.getString(PREF_USERNAME, "")


            val docRef = db.collection("users").document(user.uid)
            docRef.get()
                .addOnSuccessListener { document ->

                    if (document != null)
                    {
                        println(document.get("email").toString())

                        username.setText(document.get("id").toString())
                        mail.setText(document.get("email").toString())


                    } else {
                        //Log.d(TAG, "No such document")
                    }
                }
                .addOnFailureListener { exception ->
                    //Log.d(TAG, "get failed with ", exception)
                }


            //println("MENSAJE OSTIA" + username.text)
            //println("MENSAJE OSTIA" + mail.text)


        }

        buttonLOG_OUT.setOnClickListener {
            FirebaseAuth.getInstance().signOut() // Cerrar sesion
            startActivity(Intent(this, MainActivity::class.java))

        }


 */


        val mailLog = findViewById<EditText>(R.id.mail_Log) as EditText;
        val passLog = findViewById<EditText>(R.id.pass_Log) as EditText;

        LOG_IN_BUTTON.setOnClickListener {


            val mail = mailLog.getText().toString()
            val pass = passLog.getText().toString()


            if(mail != "" && pass != "") {
                auth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(this, OnCompleteListener { task ->

                    if(task.isSuccessful) {
                        Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else {
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                    }
                })
            } else {
                Toast.makeText(this, "Rellena los campos para log in", Toast.LENGTH_LONG).show()
            }

        }

        // Initialize Facebook Login button
        callbackManager = CallbackManager.Factory.create()

        button_facebook.setReadPermissions("email", "public_profile")
        button_facebook.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                //Log.d(TAG, "facebook:onSuccess:$loginResult")
                Toast.makeText(this@LogIn, "facebook:onSuccess:$loginResult", Toast.LENGTH_SHORT).show()
                handleFacebookAccessToken(loginResult.accessToken)
            }

            override fun onCancel() {
                //Log.d(TAG, "facebook:onCancel")
                Toast.makeText(this@LogIn, "facebook:onCancel", Toast.LENGTH_SHORT).show()
                // ...
            }

            override fun onError(error: FacebookException) {
                //Log.d(TAG, "facebook:onError", error)
                Toast.makeText(this@LogIn, "facebook:onError", Toast.LENGTH_SHORT).show()
                // ...
            }
        })// ...

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Pass the activity result back to the Facebook SDK
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }


    private fun handleFacebookAccessToken(token: AccessToken) {
        //Log.d(TAG, "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        //Log.d(TAG, "signInWithCredential:success")
                        val user = auth.currentUser
                        Toast.makeText(this@LogIn, "Succesfull Log", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, ProfileFragment::class.java))
                        //updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        //Log.w(TAG, "signInWithCredential:failure", task.exception)
                        Toast.makeText(this@LogIn, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                        //updateUI(null)
                    }

                    // ...
                }
    }


}
