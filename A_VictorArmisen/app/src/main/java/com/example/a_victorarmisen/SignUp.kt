package com.example.a_victorarmisen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*
import com.example.a_victorarmisen.UserMode
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore

class SignUp : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        auth = FirebaseAuth.getInstance()




        //
        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()





        //val buttonClick = findViewById<Button>(R.id.button_send) as Button
        val uUser = findViewById<EditText>(R.id.username_current) as EditText;
        val eEmail = findViewById<EditText>(R.id.mail_current) as EditText;
        val pPass = findViewById<EditText>(R.id.password) as EditText;

        //val mailLog = findViewById<EditText>(R.id.mail_Log) as EditText;
        //val passLog = findViewById<EditText>(R.id.pass_Log) as EditText;

        Button_SignUp.setOnClickListener {

            //startActivity(Intent(this, NewsFragment::class.java))
            println(eEmail.getText().toString());
            println(pPass.getText().toString());

            val username = eEmail.getText().toString()
            val mail = eEmail.getText().toString()
            val pass = pPass.getText().toString()

            auth.createUserWithEmailAndPassword(mail, pass)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Sign", "createUserWithEmail:success")
                        val user = auth.currentUser
                        val userModel = UserMode(user?.uid, username, mail)

                        val db = FirebaseFirestore.getInstance()
                        if (user != null) {
                            db.collection("users")
                                .document(user.uid)
                                .set(userModel)
                                .addOnSuccessListener {
                                    // Sign Up Completed!
                                    // TODO: Tell user everything was fine and finish!
                                    Log.e("SignUpActivity", "user everything was fine and finish!")
                                    Toast.makeText(this@SignUp, "user everything was fine and finish!.", Toast.LENGTH_SHORT).show()
                                    finish()
                                    startActivity(Intent(this, MainActivity::class.java))

                                }.addOnFailureListener {
                                    // TODO: Handle failure
                                    Log.e("SignUpActivity", it.message)
                                    Toast.makeText(this@SignUp, it.message, Toast.LENGTH_SHORT).show()
                                }
                        }




                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("SignUp", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(this@SignUp, "Authentication failed.", Toast.LENGTH_SHORT).show()

                    }

                    // ...
                }







        }



        LOG_IN.setOnClickListener {


            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)


            /*

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
*/
        }









    }

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

}
