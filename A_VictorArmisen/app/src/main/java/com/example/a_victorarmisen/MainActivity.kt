package com.example.a_victorarmisen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profile.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            // TODO: Go to the correct screen
            when (item.itemId) {
                R.id.home -> {
                    // TODO: Go to home
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    val fragment = HomeFragment()
                    fragmentTransaction.replace(R.id.fragment_Container, fragment)
                    fragmentTransaction.commit()
                }
                R.id.news -> {
                    // TODO: Go to home
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    val fragment = NewsFragment()
                    fragmentTransaction.replace(R.id.fragment_Container, fragment)
                    fragmentTransaction.commit()
                }
                R.id.profile -> {
                    // TODO: Go to home
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    val fragment = ProfileFragment()
                    fragmentTransaction.replace(R.id.fragment_Container, fragment)
                    fragmentTransaction.commit()
                }
                // TODO: Other tabs
            }



            true
        }







    }
}
