package com.chrisdail.slides

fun reverse(message: String): String {
    return message.reversed()
}

println(reverse("Hello World"))

// dlroW olleH

fun add(a: Int, b: Int) = a + b
println(add(1, 1))

// 2

fun addUser(name: String, city: String = "Moncton", province: String = "NB", country: String = "Canada") {
    // ...
}

addUser("Charlie")

addUser("Charlie", province = "NS", city = "Halifax")


val sum = { x: Int, y: Int -> x + y }
val diff = { x: Int, y: Int -> x - y }
fun eval(x: Int, y: Int, binaryOp: (Int,Int) -> Int): Int {
    return binaryOp(x, y)
}
println(eval(2, 1, sum))
// 3
println(eval(2, 1, diff))
// 1