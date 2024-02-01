package com.example.class20240130

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val textView1: TextView = findViewById(R.id.text1)
        textView1.setText("안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요")

        val btn2: Button = findViewById(R.id.btn2)
        btn2.visibility = View.GONE

        // 뷰 바인딩 사용시
//        val binding = ActivityMainBinding.inflate(layoutInflater)

//        setContentView(binding.root)

//        binding.text1.setText("어서오세요어서오세요어서오세요어서오세요")
//        binding.btn2.visibility = View.INVISIBLE
//        binding.btn3.setText("두번째 버튼")
    }
}


