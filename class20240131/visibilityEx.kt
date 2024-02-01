package com.example.class20240131

import com.example.class20240130.User

class visibilityEx {

}

// 접근제한자
// 클래스의 멤버를 외부에 허용하는 범위
// public, internal, protected, private

open class Super2 {
    var publicData = 10
    protected var protectedData = 20
    private var privateData = 30
}

class Sub2: Super2() {
    fun subFun() {
        publicData++
        protectedData++
        //privateData++   // 오류
    }
}

fun main() {
    val obj = Super2()
    obj.publicData++
//    obj.protectedData++     // 오류
//    obj.privateData++       // 오류
}



