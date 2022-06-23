package com.bitcode.servicesdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bitcode.servicesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       /* if(intent.hasExtra("file_path")) {
            mt("Activity: ${intent.getStringExtra("file_path")}")
        }*/

        binding.btnStart.setOnClickListener {
            var intent = Intent(this, MediaPlayerService::class.java)
            intent.putExtra("file_path", binding.edtPath.text.toString())
            startService(intent)
        }

        binding.btnStop.setOnClickListener {
            var intent = Intent(this, MediaPlayerService::class.java)
            stopService(intent)
        }

        binding.btnStartMainActivity.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("file_path", binding.edtPath.text.toString())
            startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if(intent!!.hasExtra("file_path")) {
            mt("Activity: ${intent.getStringExtra("file_path")}")
        }
    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}