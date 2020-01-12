package com.example.a_victorarmisen.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.a_victorarmisen.R

public class StreamsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_streamsdetail)

        val stream_name_textView = findViewById<TextView>(R.id.stream_name) as TextView;
        val stream_game_textView = findViewById<TextView>(R.id.game_stream) as TextView;
        val stream_video_textView = findViewById<VideoView>(R.id.video_stream) as VideoView;
        val stream_prueba_textView = findViewById<TextView>(R.id.prueba_URL_video) as TextView;

        val get_intent_name = intent.getStringExtra("name_stream")
        val get_intent_game = intent.getStringExtra("game_stream")
        val get_intent_video = intent.getStringExtra("video_stream")

        //Log.i("StreamsDetailActivity",get_intent_video);

        stream_name_textView.setText(get_intent_name)
        stream_game_textView.setText(get_intent_game)
        stream_prueba_textView.setText(get_intent_video)

        //Video
        //stream_video_textView.setVideoPath()

    }
}