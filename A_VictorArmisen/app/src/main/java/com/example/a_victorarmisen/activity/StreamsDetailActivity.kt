package com.example.a_victorarmisen.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a_victorarmisen.R

public class StreamsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_streamsdetail)

        val stream_name_textView = findViewById<TextView>(R.id.stream_name) as TextView;
        val get_intent_name = intent.getStringExtra("name_stream")

        Log.i("StreamsDetailActivity",get_intent_name);

        stream_name_textView.setText(get_intent_name)


    }
}