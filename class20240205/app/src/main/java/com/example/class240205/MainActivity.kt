package com.example.class240205

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.SearchView
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        // 뒤로 가기 버튼 코드로 나오게 하기
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // 뒤로 가기 버튼 클릭 시 자동으로 호출되는 함수 재정의
    override fun onSupportNavigateUp(): Boolean {
        Log.d("test", "뒤로 가기 버튼 누른 다음 실행됩니다.")
        //onBackPressed()
        return super.onSupportNavigateUp()
    }

    // 옵션 메뉴 나오게 하는 함수 재정의
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val menuItem1: MenuItem? =
//            menu?.add(0, 0, 0, "메뉴1")
//        val menuItem2: MenuItem? =
//            menu?.add(0, 1, 0, "메뉴2")
//        val menuItem3: MenuItem? =
//            menu?.add(0, 2, 0, "메뉴3")

//        menuInflater.inflate(R.menu.menu_main, menu)
//        return super.onCreateOptionsMenu(menu)

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu?.findItem(R.id.menu_search)

        // searchView 검색 이벤트 처리
        val searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                // 검색어 변경 이벤트
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                // 키보드의 검색 버튼을 클릭한 순간의 이벤트
                Log.d("test", query.toString())
                return true
            }
        })
        return true
    }

    // 옵션 메뉴 클릭시 이벤트 함수 재정의
    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when(item.itemId) {
            0 -> {
                Toast.makeText(this, "메뉴1을 클릭했습니다.", Toast.LENGTH_SHORT).show()
                true
            }
            1-> {
                Toast.makeText(this, "메뉴2를 클릭했습니다.", Toast.LENGTH_SHORT).show()
                true
            }
            2-> {
                Toast.makeText(this, "메뉴3을 클릭했습니다.", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
    }
}


// 플랫폼 API
// 기본 내장되어 있는 핵심 기능들
// ART(Android Runtime)

// 제트팩(JetPack)
// API 호환성 문제를 해결해줌
// 플랫폼 API에서 제공하지 않는 기능들을 제공
// androidx라는 패키지명으로 시작함
/*  androidx.appcompat : 앱의 API 레벨 호환성을 해결함
    androidx.recyclerview : 목록 화면을 구성함
    androidx.viewpager2 : 스와이프로 넘기는 화면을 구성함
    androidx.fragment : 액티비티처럼 동작하는 뷰를 제공
    androidx.drawerlayout : 옆에서 서랍처럼 열리는 화면을 구성함
 */
/*
    appcompat이 제공하는 기본뷰에 대한 라이브러리
    - AppCompatTextView, AppCompatImageView, AppCompatEditText, AppCompatButton, AppCompatRadioButton 등
    - 플랫폼 API에서 제공하는 뷰를 쓰지 않고 appcompat 라이브러리를 사용하면 호환성을 고려한 뷰 작성이 가능함
    - ex) TextView의 setLineHeight() 함수, ...
*/



