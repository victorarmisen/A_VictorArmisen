package com.example.a_victorarmisen.fragment


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.a_victorarmisen.R
import com.example.a_victorarmisen.activity.LogIn
import com.example.a_victorarmisen.activity.MainActivity
import com.example.a_victorarmisen.activity.SignUp
import com.example.a_victorarmisen.util.PREF_USERID
import com.example.a_victorarmisen.util.PREF_USERNAME
import com.example.a_victorarmisen.util.USER_PREFS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso

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
        val buttonSignUp = view.findViewById(R.id.button_send) as Button
        val buttonLogin = view.findViewById(R.id.button_login) as Button
        //val buttonClick = view.findViewById<View>(R.id.button_send) as Button
        val buttonLogOut = view.findViewById(R.id.LOG_OUT) as Button
        val imageUser = view.findViewById(R.id.image_user) as ImageView

        val URL_LOGO = "https://i.redd.it/fldyql8i8n931.png"

        Picasso.get().load(URL_LOGO).into(imageUser)

        if(FirebaseAuth.getInstance().currentUser == null)
        {

            buttonSignUp.visibility = View.VISIBLE
            buttonLogin.visibility = View.VISIBLE
            buttonLogOut.visibility = View.GONE
            imageUser.visibility = View.VISIBLE

            buttonSignUp.setOnClickListener {
                println("Hello")
                startActivity(Intent(activity, SignUp::class.java))

            }


            buttonLogin.setOnClickListener {
                startActivity(Intent(activity, LogIn::class.java))
            }

        } else {

            buttonSignUp.visibility = View.GONE
            buttonLogOut.visibility = View.VISIBLE
            buttonLogin.visibility = View.GONE
            imageUser.visibility = View.VISIBLE

            val db = FirebaseFirestore.getInstance()

            //val buttonLOG_OUT =  findViewById(R.id.LOG_OUT) as Button
            //val username = findViewById(R.id.Username_LogIn) as TextView
            //val mail = findViewById(R.id.Mail_LogIn) as TextView

            val buttonLOG_OUT = view.findViewById(R.id.LOG_OUT) as Button
            //val username = view.findViewById(R.id.Username_LogIn) as TextView
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

                            //username.setText(document.get("id").toString())
                            mail.setText(document.get("email").toString())


                        } else {
                            //Log.d(TAG, "No such document")
                        }
                    }
                    .addOnFailureListener { exception ->
                        //Log.d(TAG, "get failed with ", exception)
                    }


                buttonLOG_OUT.setOnClickListener {
                    FirebaseAuth.getInstance().signOut() // Cerrar sesion
                    startActivity(Intent(this.activity, MainActivity::class.java))

                }

            }



        }

        return view;


    }





}

