package com.example.class20240131

class ClassEx(var name: String) {
    // 변수
//    var name: String
//    var count: Int
    init {
        this.name = name
        println("주생성자입니다.")
    }
    // 생성자, 변수, 함수, 클래스

    // 보조 생성자
    constructor(name: String, count: Int) :this(name){

    }
    constructor(name: String, count: Int, addr: String) :this(name, count){

    }
    // 함수
    fun show() {
        println("함수입니다.")
        println("name: $name")
    }
    // 클래스
    class otherClass { }
}

fun main() {
    val classEx = ClassEx("kim", 10, "busan")
    classEx.name = "lee"
    classEx.show()
}

