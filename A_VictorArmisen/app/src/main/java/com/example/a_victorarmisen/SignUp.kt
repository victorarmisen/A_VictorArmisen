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
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore

class SignUp : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        auth = FirebaseAuth.getInstance()


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
                                    startActivity(Intent(this, LogIn::class.java))

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
}
