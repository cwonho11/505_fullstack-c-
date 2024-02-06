package com.example.recyclerviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewex.databinding.ItemMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

// 뷰 홀더 준비
class MyViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)

// 어댑터 준비
class MyAdapter(val binding: ItemMainBinding): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // 항목 개수를 판단하려고 자동으로 호출됨
    override fun getItemCount(): Int = datas.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // 항목의 뷰를 가지는 뷰 홀더를 준비하려고 자동으로 호출됨

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // 뷰 홀더의 뷰에 데이터를 출력하려고 자동으로 호출됨.
    }
}

// 리사이클러 뷰(Recycler View)
/*
    ViewHolder(필수): 항목에 필요한 뷰 객체를 가짐
    Adapter(필수): 항목을 구성함, 뷰홀더에 있는 뷰 객체에 데이터를 대입해 각 항목을 만들어줌
    LayoutManager(필수): 어댑터로 만든 항목을 리사이클러 뷰에 배치
    ItemDecoration(옵션): 항목을 꾸밈
 */