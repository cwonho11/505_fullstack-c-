package com.example.fragmentex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fragmentex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val fragment1 = OneFragment()
        val fragment2 = TwoFragment()
        //transaction.add(R.id.fragment_container1, fragment1)

        changeContainer(fragment1)

        binding.navMenu.setOnItemSelectedListener {
            Log.d("test", it.itemId.toString())
            when(it.itemId) {
                R.id.item_f1 -> {
                    changeContainer(fragment1)
                    true
                }
                R.id.item_f2 -> {
                    changeContainer(fragment2)
                    true
                }
                else -> false
            }
        }
    }

    fun changeContainer(fragment: Fragment) {
        // FragmentTransaction의 객체를 생성해서 프래그먼트를 화면에 출력
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_content, fragment)
        transaction.commit()
    }
}
/*
    add(int containerViewId, Fragment fragment)
    - 새로운 프래그먼트를 화면에 추가
    replace(int containerViewId, Fragment fragment)
    - 추가된 프래그먼트를 대체함
    remove(Fragment fragment)
    - 추가된 프래그먼트 제거
    commit() - 화면에 적용
 */
