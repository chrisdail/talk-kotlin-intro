package com.chrisdail.slides

import jdk.incubator.http.HttpResponse

class Person(name: String) {
    init {
        println("Created person with $name")
    }
}

data class User(var name: String, var age: Int)

fun test() {
    val (name, age) = User("Ivy", 1)
}


interface Processor {
    fun process()
}

open class Base(val p: Int) : Processor {
    private val privateField = "cannot see me"

    private fun privateFunction() = println(privateField)
    override fun process() = println("Processed")
    open fun allowsOverride() = println("Can Override")
}

class Derived(p: Int) : Base(p) {
    override fun allowsOverride() = println(p)
}


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
    println("racecar".palindrome)
    // true
}
