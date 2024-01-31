package com.example.class20240131

open class ObjectEx {
    open var data = 10
    open fun show() {
        println("super의 show() 함수 입니다. $data")
    }
}

// 오브젝트(object) 클래스
// - 익명 클래스를 만들 목적으로 사용
// - 클래스를 선언하면서 동시에 객체를 생성해야함
val obj = object: ObjectEx() {
    override var data = 10
    override fun show() {
        println("data : $data")
    }
}

// 컴패니언 클래스
// 클래스의 이름으로 멤버에 접근하고자 할 때 사용
// companion object {} 형태로 사용
class MyClass {
    companion object {
        var data = 10
        fun some() {
            println(data)
        }
    }
}

fun main() {
    obj.data = 30   // 오류 | object 키워드 뒤에 부모 클래스 선언하면 오류 안남
    obj.show()      // 오류 | object 키워드 뒤에 부모 클래스 선언하면 오류 안남

    MyClass.data = 20
    MyClass.some()
}
