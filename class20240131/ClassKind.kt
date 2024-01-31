package com.example.class20240131

class ClassKind {
}

// 데이터 클래스
class NonDataClass(val name: String, val email: String, val age: Int) { }
data class DataClass(val name: String, val email: String, val age: Int) { }
data class DataClass2(val name: String, val email: String, val age: Int) {
    lateinit var address: String
    constructor(name: String, email: String, age: Int, address: String) : this(name, email, age) {
        this.address = address
    }
}

fun main() {
    val non1 = NonDataClass("hong", "a@a.com", 10)
    val non2 = NonDataClass("hong", "a@a.com", 10)

    val data1 = DataClass("hong", "a@a.com", 10)
    val data2 = DataClass("hong", "a@a.com", 10)

    println("non data class equals: ${non1.equals(non2)}")
    println("data class equals: ${data1.equals(data2)}")

    // 데이터 클래스에서 equals()는 주생성자에 선언한 멤버 변수의 데이터 값만 같은지 비교
    val data2_1 = DataClass2("hong", "a@a.com", 10, "서울")
    val data2_2 = DataClass2("hong", "a@a.com", 10, "부산")
    println(data2_1.equals(data2_2))

    // 객체의 데이터를 반환하는 toString() 함수
    println(non1.toString())
    println(data1.toString())   // 주생성자의 매개변수로 선언된 데이터만 출력해줌
}