package com.chrisdail.slides


val value = "123"
val a: Int? = try {
    value.toInt()
} catch (e: NumberFormatException) {
    null
}

data class Person(val name: String?)
val person = Person("foo")

val firstName = person.name ?: throw IllegalArgumentException("Name required")