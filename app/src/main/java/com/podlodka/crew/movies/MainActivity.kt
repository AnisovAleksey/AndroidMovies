package com.podlodka.crew.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.podlodka.crew.movies.flutter.FlutterWorker

class MainActivity : AppCompatActivity() {
    private val flutterWorker: FlutterWorker by lazy {
        FlutterWorker(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        flutterWorker // init lazy var
    }

    fun openGameScreen() {
        flutterWorker.startActivity(this)
    }

}