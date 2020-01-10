package com.example.a_victorarmisen.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a_victorarmisen.R
import com.example.a_victorarmisen.fragment.*
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView


class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //179419492885-8keldkg96ui15t1m4sq9ual39uc9u33p.apps.googleusercontent.com

        MobileAds.initialize(this) { }
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            // TODO: Go to the correct screen
            when (item.itemId) {
                R.id.home -> {
                    // TODO: Go to home
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    val fragment =
                        HomeFragment()
                    fragmentTransaction.replace(R.id.fragment_Container, fragment)
                    fragmentTransaction.commit()
                }
                R.id.news -> {
                    // TODO: Go to home
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    val fragment =
                        NewsFragment()
                    fragmentTransaction.replace(R.id.fragment_Container, fragment)
                    fragmentTransaction.commit()
                }
                R.id.profile -> {
                    // TODO: Go to home
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    val fragment =
                        ProfileFragment()
                    fragmentTransaction.replace(R.id.fragment_Container, fragment)
                    fragmentTransaction.commit()
                }
                // TODO: Other tabs
                R.id.streams -> {
                    // TODO: Go to home
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    val fragment = StreamsFragment()
                    fragmentTransaction.replace(R.id.fragment_Container, fragment)
                    fragmentTransaction.commit()
                }

                R.id.chat -> {
                    // TODO: Go to home
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    val fragment = ChatFragment()
                    fragmentTransaction.replace(R.id.fragment_Container, fragment)
                    fragmentTransaction.commit()
                }
            }



            true
        }







    }
}
