package com.example.sample_android_architectural_components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sample_android_architectural_components.app.MyApplication

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        MyApplication.getInstance()

    }
}