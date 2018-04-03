package com.chrisdail.slides

import jdk.incubator.http.HttpResponse

class Person(name: String) {
    init {
        println("Created person with $name")
    }
}

class User(var name: String, var age: Int)

open class Base(p: Int)

class Derived(p: Int) : Base(p)

object UserService {
    fun createUser(name: String) {
        // ...
    }
}

class SomeClass() {
    val id: Int

    init {
        id = nextId++
    }

    companion object {
        private var nextId = 1
    }
}

fun <T> HttpResponse<T>.successful() = when (statusCode()) {
    in 200..299 -> true
    else -> false
}

val String.palindrome: Boolean
    get() = this.reversed() == this

fun main(args: Array<String>) {
    Person("Charlie")
    val user = User("Charlie", 20)
    println("Created user: ${user.name} age: ${user.age}")
    UserService.createUser("charlie")
    println(2.add(2))
    // 4
    println("racecar".palindrome)
    // true
}
