package com.bitcode.servicesdemo

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class MediaPlayerService : Service() {

    //private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        mt("${this.javaClass.name} : onCreate")

        /*mediaPlayer = MediaPlayer.create(this, R.raw.audio)
        mediaPlayer.prepare()
        mediaPlayer.setOnPreparedListener {
            mediaPlayer.start()
        }*/

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mt("MPS : onStartCommand $startId -- ${intent?.getStringExtra("file_path")}")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        mt("${this.javaClass.name} : onDestroy")
        //mediaPlayer.stop()
        super.onDestroy()
    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }



    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}