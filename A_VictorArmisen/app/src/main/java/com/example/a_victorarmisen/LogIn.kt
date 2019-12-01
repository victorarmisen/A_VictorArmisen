package com.example.a_victorarmisen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import org.w3c.dom.Text

import android.content.Context
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class LogIn : AppCompatActivity() {

    private lateinit var user_result  : String
    private lateinit var mail_result  : String
    private lateinit var auth: FirebaseAuth

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



    }
}
