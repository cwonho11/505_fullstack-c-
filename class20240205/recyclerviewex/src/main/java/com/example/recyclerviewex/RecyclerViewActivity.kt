package com.example.recyclerviewex

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewex.databinding.ActivityRecyclerViewBinding
import com.example.recyclerviewex.databinding.ItemMainBinding

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datas = mutableListOf<String>()
        for(i in 1..10) {
            datas.add("아이템 $i")
        }
//        datas.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
//        datas.add("bbbbbbbbbbbbbbbbbbbbbbbb")
//        datas.add("cccccccc")
//        datas.add("dddddddddddddddddddddddddddddddddddddd")
        //binding.recyclerView.layoutManager = LinearLayoutManager(this)
        // 뷰 항목을 가로로 배치
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        // 뷰를 그리드로 배치
//        val layoutManager = GridLayoutManager(this, 3,
//            GridLayoutManager.HORIZONTAL, true)
        // 뷰를 높이가 불규칙한 그리드로 배치
//        val layoutManager = StaggeredGridLayoutManager(2,
//            StaggeredGridLayoutManager.VERTICAL)
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        binding.recyclerView.adapter = MyAdapter(datas)
        binding.recyclerView.addItemDecoration(
            MyDecoration(this))
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
        // 뷰에 데이터 추가
        binding.itemRoot.setOnClickListener {
            Log.d("test", "item root click : $position")
        }
    }
}

// ItemDecoration 상속받아서 꾸미는 class
class MyDecoration(val context: Context): RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
//        c.drawBitmap(
//            BitmapFactory.decodeResource(context.resources,
//                 R.drawable.ic_launcher_foreground), 0f, 0f, null)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        // 뷰 크기 계산
        val width = parent.width
        val height = parent.height
        // 이미지 크기 계산
        val dr: Drawable? = ResourcesCompat.getDrawable(context.resources,
            R.drawable.ic_launcher_foreground, null)
        val drWidth = dr?.intrinsicWidth
        val drHeight = dr?.intrinsicHeight
        // 이미지가 그려질 위치 계산
        val left = width / 2 - drWidth?.div(2) as Int
        val top = width / 2 - drHeight?.div(2) as Int
//        c.drawBitmap(
//            BitmapFactory.decodeResource(context.resources,
//                R.drawable.ic_launcher_foreground),
//            left.toFloat(),
//            top.toFloat(),
//            null
//        )
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view) + 1
        if(index % 3 == 0) {
            outRect.set(10, 10, 10, 60)
        }
        else {
            outRect.set(10, 10, 10, 0)
        }
        view.setBackgroundColor(Color.GREEN)
        ViewCompat.setElevation(view, 20.0f)
    }
}

// 리사이클러 뷰(Recycler View)
/*
    ViewHolder(필수): 항목에 필요한 뷰 객체를 가짐
    Adapter(필수): 항목을 구성함, 뷰홀더에 있는 뷰 객체에 데이터를 대입해 각 항목을 만들어줌
    LayoutManager(필수): 어댑터로 만든 항목을 리사이클러 뷰에 배치
    ItemDecoration(옵션): 항목을 꾸밈
    - onDraw() : 항목이 배치되기 전에 호출됨
    - onDrawOver() : 항목이 모두 배치된 후 호출됨
    - getItemOffsets() : 개별 항목을 꾸밀 때 호출됨

 */