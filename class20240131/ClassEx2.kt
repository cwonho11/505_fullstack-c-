package com.example.class20240131

class ClassEx2 {

}

open class Adder(var num1: Int, var num2: Int) {

    open fun calc() {
        println("$num1 + $num2 = ${num1 + num2}")
    }
//    var num1 = 0
//    var num2 = 0
//    constructor(num1: Int, num2: Int) {
//        this.num1 = num1
//        this.num2 = num2
//    }
}

class Subtracter(num1: Int, num2: Int): Adder(num1, num2) {
    override fun calc() {
        println("$num1 - $num2 = ${num1 - num2}")
    }
}

open class Rect {
    open fun draw() {
        println("사각형")
    }
}

class Triangle: Rect() {
    override fun draw() {
        println("삼각형")
    }
}

class Circle: Rect() {
    override fun draw() {
        println("원")
    }
}

fun main() {
    // Adder 클래스를 작성하여
    // 두 수를 전달받아서 더한 값을 리턴해주는 calc() 메서드 작성
    // Subtracter 클래스를 작성하여 Adder 클래스를 상속받아
    // calc() 두 수를 뺀 값을 리턴해주는 메서드로 재정의하세요
    val add = Adder(20, 30)
    add.calc()

    val sub = Subtracter(100, 20)
    sub.calc()

    // 사각형을 그리는 Rect라는 클래스 선언
    // draw()라는 함수를 이용해 "사각형" 문자열을 출력
    // "삼각형"을 그리는 Triangle이라는 클래스 선언
    // Rect라는 클래스를 상속받아서 draw() 함수 재정의
    // "원"을 출력하는 Circle(Rect 상속)이라는 클래스 선언
    // 만들 클래스 Rect, Triangle, Circle
    // 만들 공통 함수 draw()
    val rect = Rect()
    rect.draw()

    val tri = Triangle()
    tri.draw()

    val circle = Circle()
    circle.draw()
}






