package com.example.coroutine_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClicked = findViewById<Button>(R.id.btnClicked)
        val txtData = findViewById<TextView>(R.id.txtData)

        var sum = 0L
        btnClicked.setOnClickListener {
            var time = measureTimeMillis {
                for(i in 1..2_000_000_000_000) {
                    sum += i
                }
            }
            Log.d("test", "time : $time")
            txtData.text = "sum : $sum"
        }
    }
}