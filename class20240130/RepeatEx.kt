package com.example.class20240130

import java.util.Scanner

class RepeatEx {
}

fun main() {
    // 1. 1부터 100까지 3의 배수의 합
    var sum = 0;
    for(i in 1..100) {
        if(i % 3 == 0) {
            sum = sum + i
        }
    }
    println("1부터 100까지 3의 배수의 합은? $sum")

    // 2. 구구단 출력
    /*
    2x1=2   3x1=3 ...   9x1=9
    2x2=4   3x2=6
    ...
    2x9=18  3x9=27...   9x9=81
     */
    for(i in 1..9){
        for(j in 2..9){
            print("${j}x${i}=${i*j}\t")
        }
        println()
    }

    // 3. 78점의 학점은 몇 등급인지 알아보세요(when사용)
    // A - 90이상 / B - 80이상 / C - 70이상 / D - 60이상 / F - 60미만
    val score = 78;
    when {
        score >= 90 -> println("${score}는 A입니다.")
        score >= 80 -> println("${score}는 B입니다.")
        score >= 70 -> println("${score}는 C입니다.")
        score >= 60 -> println("${score}는 D입니다.")
        else -> println("${score}는 F입니다.")
    }

    // ("love", "rabbit", "orange")값을 가지는 배열 engArr
    // ("사랑", "토끼", "오렌지")의 값을 가지는 배열 korArr
    // 영어 단어를 입력 받아서 한글로 출력하는 프로그램을 작성하세요.
    // ex) 영단어 입력>>love
    //     사랑
    //     영단어 입력>>live
    //     그런 단어는 없습니다.
    //     영단어 입력>>exit
    //     종료합니다..
    val engArr = arrayOf<String>("love", "rabbit", "orange")
    val korArr = arrayOf<String>("사랑", "토끼", "오렌지")

    val sc: Scanner = Scanner(System.`in`)

    while(true) {
        print("영단어 입력>>")
        var input = sc.next();
        if(input.equals("exit")) {
            println("종료합니다..")
            break;
        }
        for(i in engArr.indices) {      // 0 1 2
            if(input.equals(engArr.get(i))) {
                println(korArr.get(i))
                break;
            }
            if(i == engArr.size - 1){
                println("그런 영어 단어는 없습니다.")
            }
        }
    }
}