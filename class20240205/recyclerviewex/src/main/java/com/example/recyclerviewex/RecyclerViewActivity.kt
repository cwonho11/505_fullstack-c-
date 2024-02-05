package com.example.recyclerviewex

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewex.databinding.ActivityRecyclerViewBinding
import com.example.recyclerviewex.databinding.ItemMainBinding

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datas = mutableListOf<String>()
        for(i in 1..10) {
            datas.add("Item $i")
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter(datas)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }
}

// 뷰 홀더 준비
class MyViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)

// 어댑터 준비
class MyAdapter(val datas: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // 항목 개수를 판단하려고 자동으로 호출됨
    override fun getItemCount(): Int = datas.size

    // 항목의 뷰를 가지는 뷰 홀더를 준비하려고 자동으로 호출됨
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // 뷰 홀더의 뷰에 데이터를 출력하려고 자동으로 호출됨.
        Log.d("test", "onBindViewHolder : $position")
        val binding = (holder as MyViewHolder).binding
        // 뷰에 데이터 출력
        binding.itemData.text = datas[position]
        // 뷰에 이벤트 추가
        binding.itemRoot.setOnClickListener {
            Log.d("test", "item root click : $position")
        }
    }
}

// 리사이클러 뷰(Recycler View)
/*
    ViewHolder(필수): 항목에 필요한 뷰 객체를 가짐
    Adapter(필수): 항목을 구성함, 뷰홀더에 있는 뷰 객체에 데이터를 대입해 각 항목을 만들어줌
    LayoutManager(필수): 어댑터로 만든 항목을 리사이클러 뷰에 배치
    ItemDecoration(옵션): 항목을 꾸밈
 */

