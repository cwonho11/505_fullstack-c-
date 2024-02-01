package com.example.eventex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import com.example.eventex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn1.setOnClickListener({
            Log.d("test", "버튼1을 클릭했습니다.")
        })

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d("test", "Touch down event 발생")
                Log.d("test", "x: ${event.x}, rawX: ${event.rawX}")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("test", "Touch up event 발생")
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("test", "onKeyDown 발생")
        when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("test", "볼륨 업 버튼 누름")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("test", "볼륨 다운 버튼 누름")
            KeyEvent.KEYCODE_HOME -> Log.d("test", "홈 버튼 누름")
            KeyEvent.KEYCODE_POWER -> Log.d("test", "전원 버튼 누름")
            KeyEvent.KEYCODE_BACK -> Log.d("test", "뒤로 가기 버튼 누름")
        }

        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("test", "onKeyUp 발생")
        return super.onKeyUp(keyCode, event)
    }

    override fun onKeyLongPress(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("test", "onKeyLongPress 발생")
        return super.onKeyLongPress(keyCode, event)
    }
}

/*
    터치 이벤트 종류
    - ACTION_DOWN : 화면을 손가락으로 누른 순간의 이벤트
    - ACTION_UP : 화면에서 손가락을 떼는 순간의 이벤트
    - ACTION_MOVE : 화면을 손가락으로 누른 채로 이동하는 순간의 이벤트

    키 이벤트
    onKeyDown : 키를 누른 순간의 이벤트
    onKeyUp : 키를 떼는 순간의 이벤트
    onKeyLongPress : 키를 오래 누르는 순간의 이벤트

                리스너
    이벤트 소스 -------->  이벤트 핸들러

    이벤트 소스: 이벤트가 발생한 객체
    이벤트 핸들러: 이벤트 발생 시 실행할 로직이 구현된 객체
    리스너: 이벤트 소스와 이벤트 핸들러를 연결해 주는 함수
 */

