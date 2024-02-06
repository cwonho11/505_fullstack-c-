package com.example.drawerlayoutex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ActionBarDrawerToggle 버튼 적용
        toggle = ActionBarDrawerToggle(this,
            findViewById(R.id.drawer), R.string.drawer_opened, R.string.drawer_closed)
        // up버튼(뒤로가기) 버튼 나오게 함
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // <- 아이콘을 햄버거 아이콘으로 변경하기 위함
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 이벤트가 토글 버튼에서 발생하면
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}