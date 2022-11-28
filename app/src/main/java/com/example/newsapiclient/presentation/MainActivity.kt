package com.example.newsapiclient.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapiclient.R
import dagger.hilt.android.HiltAndroidApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}