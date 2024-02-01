package com.example.class20240131

class LamdaEx {
}

// 일반적인 함수 형태
// fun 함수명(매개변수) { 함수 본문 }

// 람다 함수 형태
// { 매개변수 -> 함수 본문 }
/*
   코틀린에서 람다 함수 사용 규칙
   - 람다 함수는 {} 사용해서 표현
   - {} 안에 화살표(->)가 있고 왼쪽은 매개변수, 오른쪽은 함수본문
   - 함수 반환은 함수 본문의 마지막 표현식임
 */

fun sum(no1: Int, no2: Int): Int {
    return no1 + no2
}

val sum2 = { no1: Int, no2: Int  -> no1 + no2 }

// 고차 함수(high order function)
// - 매개변수 또는 반환 타입이 함수인 경우
fun hofFun(arg: (Int) -> Boolean): () -> String {
    val result = if(arg(10)) {
        "valid"
    } else {
        "invalid"
    }
    return {"hofFun result : $result"}
}

// 함수 타입의 별칭(typealias)
typealias MyFunType = (Int, Int) -> Int
fun main() {
    // 고차 함수 호출
    val result = hofFun({ no -> no > 0 })
    println(result())

    //  람다함수 호출
    //    sum2(30, 40)
    // 람다함수 선언과 동시에 호출
    //{ no1: Int, no2: Int -> no1 + no2 } (20, 30);
    // 매개변수 없는 함수(-> 생략 가능)
    //{ -> println("함수 호출") }
    //{ println("함수 호출") }

    // 람다 함수의 반환문
    val some = { no1: Int, no2: Int ->
        println("람다 함수의 return")
        no1 + no2
    }

    // 람다 함수 호출
    println("result = ${some(10, 20)}")

    // 함수 타입 선언
    // 함수 타입 - 함수를 선언할 때 사용하는 매개변수와 반환 타입
    fun add(no1: Int, no2: Int): Int {
        return no1 + no2
    }
    // (Int, Int) -> Int - 함수 타입
    // { no1: Int, no2: Int -> no1 + no2 } - 함수 내용
    val add2: (Int, Int) -> Int = { no1: Int, no2: Int -> no1 + no2 }

    // 함수 타입 별칭 사용(typealias)
    val add3: MyFunType = { no1: Int, no2: Int -> no1 + no2 }

    // 매개변수 타입 생략 가능
    val add4: (Int, Int) -> Int = { no1, no2 -> no1 + no2 }

    // 함수 타입 생략 가능
    val add5 = { no1: Int, no2: Int -> no1 + no2 }
}

