package com.example.class20240130

import java.text.SimpleDateFormat
import java.util.Date

var data = 10

fun formatData(date: Date): String {
    val sdformat = SimpleDateFormat("yyyy-MM-dd")
    return sdformat.format(date)
}

val data4: Int by lazy {
    println("use lazy...")
    100
}

class User {
    var name = "hello"
    var name2 : String = "data"
    var name3 : String? = null

    fun sayHello() {
        val test : String
        var number = 10
        number = 20
        println("name : $name")
    }
}

fun main() {
    println("Hello kotlin")
    val str = """
       안녕하세요? 
    오늘 날씨는 
            맑습니다.
    """
    print(str)
    val str2 = "문자열 템플릿"
    println("문자열 : $str2")

    fun some(data1: Int = 100, data2: Int): Int {
        return data1 + data2
    }

    println("기본값 결과 : " + some(data2 = 300))    // 100 + 300

    println("배열 결과 출력")
    val arr: Array<String> = Array(3, {"영"})
    arr[0] = "일"
    //arr[1] = "이"
    arr.set(2, "삼")

    println(arr.get(0))
    println(arr[1])
    println(arr.get(2))

    var list = listOf<Int>(10, 20, 30)
    println("""
        list size : ${list.size}
        list data : ${list[0]}, ${list.get(1)}, ${list.get(2)}
    """)

    var mutableList = mutableListOf<Int>(10, 20, 30)
    mutableList.add(3, 40)  // list의 index위치에 추가
    mutableList.set(0, 50)               // list의 0번째 자리값 변경

}

/* 데이터 타입
    코틀린에서 모든 변수는 객체이므로 데이터 타입은 모두 객체 타입
    기본 데이터 타입
    - Int, Short, Long, Double, Float, Byte, Boolean

    문자, 문자열 타입
    - Char(''), String("")
    - """~""" : 특수기호 사용없이 띄어쓰기나 엔터 등을 표현 가능
    문자열 템플릿 : String 타입을 사용할 때 변수값이나 연산식의 결과를
                 포함해야 될 때 사용(변수 앞에 $ 사용)

    Any - 모든 타입 가능

    Unit - 반환문이 없는 함수(생략 가능)

    Nothing - null만 대입 가능 또는 예외처리 시 사용
*/

/*
    널 허용(nullable - ?사용), 널 불허용(not null)
*/

/*
*   함수 사용시 매개변수에 기본값 사용 가능
*   fun some(data1: Int, data2: Int = 100): Int {
*       return data1 + data2
*   }
*   // 둘 다 사용가능
*   println(some(200))          // 200 + 100
*   println(some(500, 1000))    // 500 + 1000
*
*   매개변수 지정하여 호출 가능
*   some(data2 = 10, data1 = 30)
*
*
*/
/*
    컬렉션 타입 - Array, List, Set, Map
    Array(배열)
    사용1 - Array(size: Int, init: 초기값)
    ex) val data1: Array<Int> = Array(3, { 0 })
    배열 접근은 []사용 또는 .get() / .set() 사용
    data1[1] or data1.get(1), data1.set(2, 50)

    사용2 - BooleanArray, ByteArray, CharArray, DoubleArray,
           FloatArray, IntArray, LongArray, ShortArray
    ex) val data1: IntArray = IntArray(3, {0})
        val data2: BooleanArray = BooleanArray(2, {false})

    사용3 - arrayOf()
    ex) val data1 = arrayOf<Int>(10, 20, 30)
    booleanArrayOf(), byteArrayOf(), charArrayOf(), doubleArrayOf(),
    floatArrayOf(), intArrayOf(), longArrayOf(), shortArrayOf()
    도 사용 가능
    ex) val data2 = intArrayOf(10, 20, 30)

    List, Set, Map
    List : 순서가 있는 데이터 집합, 중복 허용
    Set : 순서가 없는 데이터 집합, 중복 허용 안함
    Map : 키와 값으로 이루어진 데이터 집합, 순서 없고 키 중복 허용안함

    Collection 타입은 가변(mutable) 클래스와 불변(immutable) 클래스로 나뉨
    불변은 초기에 데이터를 대입하면 더이상 변경할 수 없음
    가변은 계속해서 데이터 변경 가능
    불변 클래스 - List, Set, Map
    불변 타입은 size(), get()함수만 제공
    가변 클래스 - MutableList, MutableSet, MutableMap
    가변 타입은 size(), get(), add(), set() 함수 사용 가능

    Map은 Pair객체를 이용하거나 '키 to 값'의 형태로 이용할 수 있음
    ex) Pair("one", "hello") or "two" to "world"
 */

/*

 */


