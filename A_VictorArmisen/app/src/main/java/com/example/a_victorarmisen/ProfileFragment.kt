package com.example.a_victorarmisen


import android.R.id
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_profile.*;

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment()  {


    private lateinit var user_result  : String
    private lateinit var mail_result  : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val buttonClick = view.findViewById<View>(R.id.button_send) as Button


        if(FirebaseAuth.getInstance().currentUser == null)
        {

            buttonClick.visibility = View.VISIBLE

            buttonClick.setOnClickListener {
                println("Hello")
                startActivity(Intent(activity, SignUp::class.java))

            }

        } else {

            buttonClick.visibility = View.GONE

            val db = FirebaseFirestore.getInstance()

            //val buttonLOG_OUT =  findViewById(R.id.LOG_OUT) as Button
            //val username = findViewById(R.id.Username_LogIn) as TextView
            //val mail = findViewById(R.id.Mail_LogIn) as TextView

            val buttonLOG_OUT = view.findViewById(R.id.LOG_OUT) as Button
            val username = view.findViewById(R.id.Username_LogIn) as TextView
            val mail = view.findViewById(R.id.Mail_LogIn) as TextView

            //val eEmail = findViewById<EditText>(R.id.mail_current) as EditText;
            val user = FirebaseAuth.getInstance().currentUser

            if (user != null)
            {

                val username_collection = db.collection("users").document(user.uid).get()

                val editor = this.getActivity()?.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)
                    ?.edit()
                //val username2 = eEmail.getText().toString()

                if (editor != null) {
                    editor.putString(PREF_USERID, user.uid)
                    editor.putString(PREF_USERNAME, username_collection.toString())
                } else {
                    //Editor is null
                }

                val userPreferences = this.getActivity()?.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)
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

                buttonLOG_OUT.setOnClickListener {
                    FirebaseAuth.getInstance().signOut() // Cerrar sesion
                    startActivity(Intent(this.activity, MainActivity::class.java))

                }

            }



        }











        return view;


    }





}

