package com.example.a_victorarmisen.activity

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.EditText
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.a_victorarmisen.R
import java.net.URI

public class StreamsDetailActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer ?= null
    val mediaController: MediaController ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_streamsdetail)



        val stream_name_textView = findViewById<TextView>(R.id.stream_name) as TextView;
        val stream_game_textView = findViewById<TextView>(R.id.game_stream) as TextView;
        val stream_video = findViewById<VideoView>(R.id.video_stream) as VideoView;
        val stream_prueba_textView = findViewById<TextView>(R.id.prueba_URL_video) as TextView;

        val get_intent_name = intent.getStringExtra("name_stream")
        val get_intent_game = intent.getStringExtra("game_stream")
        val get_intent_video = intent.getStringExtra("video_stream")

        //Log.i("StreamsDetailActivity",get_intent_video);

        stream_name_textView.setText(get_intent_name)
        stream_game_textView.setText(get_intent_game)
        stream_prueba_textView.setText(get_intent_video)

        //Video
<<<<<<< HEAD


        //stream_video.setVideoPath(get_intent_video)
        stream_video.setMediaController(MediaController(this));
        stream_video.setVideoURI(Uri.parse(get_intent_video))
        //val mP =  MediaPlayer.create(this, Uri.parse(get_intent_video))
        //mP.start()
        stream_video.start()



        /*

        */





=======
        //stream_video_textView.setVideoPath()
>>>>>>> parent of 8a42e7c... Video API working

    }
}