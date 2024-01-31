package com.example.class20240131

class InheritEx {

}

// 상속
open class Super(name: String) {
    open var superData = 10
    open fun superfun() {
        println("수퍼클래스의 함수")
    }
}
// 주생성자로 상속
// class Sub(name: String): Super(name) {

// }

// 보조생성자로 상속
class Sub: Super {
    // 오버라이딩
    override var superData = 20
    override fun superfun() {
        println("서브클래스의 함수")
    }

    constructor(name: String): super(name) {
    }
}

fun main() {
    val sub = Sub("kim")
    sub.superData = 20      // 슈퍼클래스의 멤버변수 접근
    sub.superfun()          // 슈퍼클래스의 함수 접근
}


