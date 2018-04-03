package com.chrisdail.slides

for (n in 1..100) {
    println(when {
        n % 15 == 0 -> "FizzBuzz"
        n % 5 == 0 -> "Fizz"
        n % 3 == 0 -> "Buzz"
        else -> n
    })
}
