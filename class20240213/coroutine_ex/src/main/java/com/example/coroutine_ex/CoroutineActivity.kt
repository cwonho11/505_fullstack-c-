package com.example.coroutine_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class CoroutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClicked = findViewById<Button>(R.id.btnClicked)
        val txtData = findViewById<TextView>(R.id.txtData)

        val channel = Channel<Int>()
        var sum = 0L
        btnClicked.setOnClickListener {
            // Dispoatchrs.Default - 백그라운드에서 동작(시간이 오래 걸리는 작업을 백그라운드에서 실행 )
            val backgroundScope = CoroutineScope(Dispatchers.Default + Job())
            backgroundScope.launch {

                var time = measureTimeMillis {
                    for(i in 1..2_000_000_000) {
                        sum += i
                    }
                }
                Log.d("test", "time : $time")
                channel.send(sum.toInt())
            }
            // Dispatchers.Main - 메인 스레드에서 동작하는 코루틴을 만듬(화면에 결과값 표시)
            val mainScope = GlobalScope.launch(Dispatchers.Main) {
                channel.consumeEach {
                    txtData.text = "sum : $it"
                }
            }
        }
    }
}