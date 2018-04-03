package com.chrisdail.slides

val lastName: String? = "Dail"
data class Person(var name: String)
val person = lastName?.let {
    Person(it)
}

"Hello World".run {
    println(toUpperCase())
    println(reversed())
}
// HELLO WORLD
// dlroW olleH


class Address {
    var line: String? = null
    var city: String? = null
    var province: String? = null
    var country: String? = null
}

val address = Address().apply {
    line = "123 Fake Street"
    city = "Moncton"
    province = "NB"
    country = "Canada"
}