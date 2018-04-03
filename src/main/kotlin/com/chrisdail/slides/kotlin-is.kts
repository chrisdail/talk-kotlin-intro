package com.chrisdail.slides

import kotlin.math.pow

class Square(val length: Double) {
    fun area() = length.pow(2)
}

fun areaOfSquare(length: Double) = length.pow(2)

println(Square(2.0).area())
println(areaOfSquare(2.0))
println(listOf(2.0).map(::areaOfSquare).first())
