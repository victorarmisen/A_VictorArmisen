package com.example.a_victorarmisen.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.a_victorarmisen.R
import com.example.a_victorarmisen.fragment.ProfileFragment
import com.example.a_victorarmisen.util.UserMode
import com.example.a_victorarmisen.viewmodels.RegisterViewModel
import com.facebook.*
import com.google.firebase.auth.FacebookAuthProvider
import com.facebook.login.LoginResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_sign_up.view.*


class SignUp : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth
    private lateinit var callbackManager: CallbackManager

    //VIEWMODEL
    lateinit var viewModel: RegisterViewModel


    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

/*
        LOG_IN.setOnClickListener {


            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)




            val mail = mailLog.getText().toString()
            val pass = passLog.getText().toString()


            if(mail != "" && pass != "") {
                auth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(this, OnCompleteListener { task ->

                    if(task.isSuccessful) {
                        Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, LogIn::class.java)
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
 */



    /*
    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
                // ...
            }
        }
    }


    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        //Log.d(TAG, "firebaseAuthWithGoogle:" + acct.id!!)

        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "signInWithCredential:failure", task.exception)
                    //Snackbar.make(main_layout, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
                    //updateUI(null)
                }

                // ...
            }
    }
*/
/*
    // Initialize Facebook Login button
    callbackManager = CallbackManager.Factory.create()

    button_facebook.setReadPermissions("email", "public_profile")
    button_facebook.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
        override fun onSuccess(loginResult: LoginResult) {
            //Log.d(TAG, "facebook:onSuccess:$loginResult")
            Toast.makeText(this@SignUp, "facebook:onSuccess:$loginResult", Toast.LENGTH_SHORT).show()
            handleFacebookAccessToken(loginResult.accessToken)
        }

        override fun onCancel() {
            //Log.d(TAG, "facebook:onCancel")
            Toast.makeText(this@SignUp, "facebook:onCancel", Toast.LENGTH_SHORT).show()
            // ...
        }

        override fun onError(error: FacebookException) {
            //Log.d(TAG, "facebook:onError", error)
            Toast.makeText(this@SignUp, "facebook:onError", Toast.LENGTH_SHORT).show()
            // ...
        }
    })// ...


 */

}
/*
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
                    Toast.makeText(this@SignUp, "Succesfull Log", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, ProfileFragment::class.java))
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "signInWithCredential:failure", task.exception)
                    Toast.makeText(this@SignUp, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }

                // ...
            }
    }
*/
}
