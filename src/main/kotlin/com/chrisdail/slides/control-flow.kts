package com.chrisdail.slides

val x = 100

when (x) {
    -1 -> println("INVALID")
    0, 1 -> println("0 or 1")
    in 2..100 -> println("x == $x")
    else -> println("otherwise")
}