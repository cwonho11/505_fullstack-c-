package com.example.class20240130

import java.util.Scanner

class Repeat {
}

fun main() {
    var data = 11

    if (data > 10) {
        println("data > 10")
    } else if (data > 0 && data <= 10) {
        println("data > 0 && data <= 10")
    } else {
        println("data <= 0")
    }

    // 표현식을 사용할 때는 else문을 생략할 수 없음
    // if-else 형태나 if-else if-else 형태가 되어야함
    val result = if(data > 0) {
        println("data > 0")
        true
    } else {
        println("data <= 0")
        false
    }
    println(result)

    when (data) {
        10 -> println("data is 10")
        20 -> println("data is 20")
        else -> {
            println("data is not valid data")
        }
    }

    var select: Any = 5
    when(select) {
        is String -> println("문자열 타입입니다.")
        20, 30 -> println("20 또는 30의 값입니다.")
        in 1..10 -> println("1~10의 값입니다.")
        else -> println("유효하지 않는 값입니다.")
    }

    var select2 = 3
    when {
        select2 > 10 -> println("10보다 큰 수 입니다.")
        select2 <= 10 -> println("10보다 같거나 작은 수입니다.")
    }

    // 표현식으로 사용시 반드시 else문이 있어야함
    val result2 = when {
        select2 <= 10 -> println("10보다 작거나 같은 수입니다.")
        select2 > 10 -> println("10보다 큰 수 입니다.")
        else -> println("그 외에 수입니다.")
    }
    println(result2)

    // 배열 인덱스만큼 반복
    var arr = arrayOf<Int>(10, 20, 30)
    for (i in arr.indices) {
        print(arr[i])
        if(i !== arr.size - 1) print(",")
    }
    println()

    // 인덱스와 데이터를 함께 가져옴
    for((index, value) in arr.withIndex()) {
        print(value)
        if(index !== arr.size - 1) print("/")
    }
    println()

    var x = 1
    while(x <= 5) {
        if(x == 3) {
            println("종료합니다")
            break;
        }
        println(x++)
    }


}

/*
    for문(주로 in 연산자와 함께 사용)
    for(i in 1..10)         // 1~10까지 1씩 증가
    for(i in 1 until 10)    // 1~9까지 1씩 증가
    for(i in 2..10 step2)   // 2~10까지 2씩 증가
    for(i in 10 downTo 1)   // 10~1까지 1씩 감소
 */