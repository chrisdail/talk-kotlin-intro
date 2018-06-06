name: heading
layout: true
class: center, middle, inverse

---

name: inverse
layout: true
class: middle, inverse

---

template: heading

![:scale 20%](images/Kotlin-logo.svg)

# val kotlin: Introduction

Chris Dail - [@chrisdail](http://twitter.com/chrisdail)

Senior Director, Software Engineering

![:scale 20%](images/Akiri-Logo.png)

Slides - [github.com/chrisdail/talk-kotlin-intro](https://github.com/chrisdail/talk-kotlin-intro)

---

template: heading
# Kotlin

---

template: heading
# Fastest Growing Programming Language

---

template: heading
# PYPL - [pypl.github.io](pypl.github.io/)

![:scale 58%](images/pypl.png)

---

template: heading
# StackOverflow

![:scale 90%](images/kotlin-so.png)

---

template: heading
# But Why?

---

template: heading
# Google IO 2017

![:scale 60%](images/google-io.png)

---

# Why Kotlin?

From The Authors:

> "We want to become more productive by switching to a more expressive language. At the same time, we cannot accept compromises in terms of either Java interoperability or compilation speed." - JetBrains Blog

---

# Kotlin Is

- General purpose programming language
- Open Source (Apache 2)
- Statically Typed
- Concise, safe, pragmatic
- Interoperable
- Object Oriented, Procedural, Functional

---

template: heading

# Kotlin Myths

Misconceptions about the language

---

template: heading

![:scale 70%](images/ios-vs-android.png)
# Kotlin is Google's answer to Apple's Swift

--

Kotlin started in 2011 by JetBrains with 1.0 in 2016

Android support was only announced in 2017

---

template: heading

![:scale 80%](images/kotlin-vs-swift.png)
# Kotlin is a Swift Clone

--

Swift started in 2010 but Apple only announced it in 2014

---

template: heading

![:scale 20%](images/java.png)
# Kotlin is only for Java Developers

--

Kotlin is a modern, pragmatic language with excellent interop

Initially meant JVM but now extends to JavaScript and Native

---

template: heading

# Kotlin offers little over Java 8/9/10

--

Java has made some improvements recently but is still far from modern

Don't take my word for it...

---

template: heading

![:scale 50%](images/basics.jpg)
# Basics

---

layout: false

# Creating Variables

- name `:` type
- Variables require initialization

```kotlin
var message: String = "Hello World!"
```

--
- Inferred Types

```kotlin
var message = "Hello World!"
```

--
- Immutable is preferable

```kotlin
val message = "Hello World Forever!"
```

---

# Strings

- Interpolation

```kotlin
var planet = "Earth"
println("Hello $planet")
println("HELLO ${planet.toUpperCase()}")
```

---

# Nulls

- `Any` - All classes extend from Any

--
- `Any?` - Nullable Type

```kotlin
var neverNull: String = "hi"
//neverNull = null   // Compilation Error
var message: String? = "hi"
message = null
```

--
- `?.` - Null-safe calls

```kotlin
//message.length   // Compilation Error
message?.length
// Equivalent Java: (message == null) ? null : message.length
```

---

# Scoping Function: `let`

```kotlin
val person = lastName.let {
    Person(it)
}
```
- Takes the argument as a parameter (default: `it`)
- Result is the last value (functional like a transform/map)
--

- More concise Null-checking

```kotlin
val username = usernameOrNull()
if (username != null) {

}
```

```kotlin
usernameOrNull()?.let { username ->

}
```

---

template: heading
![](images/Elvis-Operator.png)

# Elvis Operator

---

# `?:` - Elvis Operator

- Returns left if not null, otherwise right

```kotlin
val length = message?.length ?: -1
```

- Can be combined with `throw` or `return`

```kotlin
val map = mapOf("name" to "Ivy")
val name = map["name"] ?: throw IllegalArgumentException()
```

---

template: heading

![:scale 50%](images/control-flow.jpg)
# Control Flow

---

# If / Else

- Traditional

```kotlin
var max: Int
if (a > b) {
    max = a
} else {
    max = b
}
```

- As Expression

```kotlin
val max = if (a > b) a else b
```

---

# When

- Switch-like

```kotlin
when (x) {
    -1 -> println("INVALID")
    0, 1 -> println("0 or 1")
    in 2..100 -> println("x == $x")
    else -> println("otherwise")
}
```

- if-else chain

```kotlin
when {
    x.isOdd() -> print("x is odd")
    x.isEven() -> print("x is even")
    else -> print("x is funny")
}
```
---

# Exceptions

- No checked exceptions
    - Debated topic in the Java community (Spring)
    - Leads to empty `try/catch` blocks
- `try/catch` is an expression (can return a value)

```kotlin
val a: Int = try {
    value.toInt()
} catch (e: NumberFormatException) {
    -1
}
```

--

```kotlin
val b = value.toIntOrNull() ?: -1
```

---

# For

- Loop over list

```kotlin
for (value in ints) {
    println(value)
}
```

- With Ranges

```kotlin
for (i in 1..3) {
    println(i)
}
```

---

# Putting it all together

- Fizz Buzz

```kotlin
for (n in 1..100) {
    println(when {
        n % 15 == 0 -> "FizzBuzz"
        n % 3 == 0 -> "Fizz"
        n % 5 == 0 -> "Buzz"
        else -> n
    })
}
```

---

template: heading

![:scale 50%](images/functions.jpg)
# Functions

---

# Functions

- No class required
- Simple function

```kotlin
fun reverse(message: String): String {
    return message.reversed()
}
println(reverse("Hello World"))

// dlroW olleH
```

- One Liner

```kotlin
fun add(a: Int, b: Int) = a + b
println(add(1, 1))

// 2
```

---

# Arguments

- Default/Optional Arguments

```kotlin
fun addUser(name: String, city: String = "Moncton", province:
        String = "NB", country: String = "Canada") {
    // ...
}

addUser("Charlie")
```

- Named Arguments

```kotlin
addUser("Charlie", province = "NS", city = "Halifax")
```

---

# Lambdas / Closures

- Last line is the returned value
```kotlin
val sum = { x: Int, y: Int ->
        x + y
}
```
- Higher Order Functions
```kotlin
val diff = { x: Int, y: Int -> x - y }
fun eval(x: Int, y: Int, binaryOp: (Int,Int) -> Int): Int {
        return binaryOp(x, y)
}
println(eval(2, 1, sum))
// 3
println(eval(2, 1, diff))
// 1
```

---

template: heading

![:scale 50%](images/classes.jpg)
# Classes

---

# Class

- Simple Constructor with init block
```kotlin
class Person(name: String) {
        init {
            println("Created person with $name")
        }
}
```

- Class with properties
```kotlin
class User(var name: String, var age: Int)
val user = User("Charlie", 20)
println("Created user: ${user.name} age: ${user.age}")
```

---

# Inheritance

```kotlin
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
```

---

# Properties

- Basic declaration
```kotlin
class Address {
        var name: String = ""
        var street: String = ""
        var city: String = ""
        var state: String? = null
        var zip: String = ""
}
```

- Custom getter/setter
```kotlin
val isEmpty: Boolean
        get() = this.size == 0
```

---

# Data Classes

- Easy way to create DTO / POJO
- Most data classes can be one liners
```kotlin
data class User(var name: String, var age: Int)
```
- Adds some default functions based on the constructor:
    - `equals()` and `hashCode()` pair
    - `toString()` of the form `User(name=Ivy, age=42)`
    - `copy()` function - Creates a copy of this class
- Destructuring
```kotlin
val (name, age) = User("Ivy", 1)
```

---

# Objects

- Singleton as object declaration
```kotlin
object UserService {
        fun createUser(name: String) {
            // ...
        }
}
UserService.createUser("charlie")
```

---

# Companion Object

- Kotlin has no `static` keyword
- `companion object` is an associated object
- Fields and functions on the class

```kotlin
class SomeClass() {
    val id: Int

    init {
        id = nextId++
    }

    companion object {
        private var nextId = 1
    }
}
```

---

# Extension

- Adding to existing classes
- Extension Functions

```kotlin
fun <T> HttpResponse<T>.successful() = when (statusCode()) {
        in 200..299 -> true
        else -> false
}
```

- No 'magic' here. Imported like any other function

---

template: heading

![:scale 50%](images/marbles.jpg)
# Collections

---

# Lists and Sets

```kotlin
val empty = emptyList<String>()
val list = listOf(1, 1, 2, 3)
val mutableList = mutableListOf<String>()
mutableList.add("hello")

println(list[0])
// 1

println(list + listOf(5, 8))
// [1, 1, 2, 3, 5, 8]

println(setOf(1, 1, 2, 3))
// [1, 2, 3]
```

---

# Maps

```kotlin
val emptyMap = emptyMap<String,String>()
val map = mapOf("a" to 1, "b" to 2, "c" to 3)
println(map["b"])
// 2
val mutableMap = mutableMapOf<String,String>()
mutableMap["hello"] = "world"
```

---

# Collection Manipulation

- Great standard library for manipulating
- `filter`, `map`, `find`, `fold`, `forEach`, `groupBy`, `min/max`, `reduce`, `sort`
- Example:
    - Find the minimum `ttl` value between both sources and destinations

```kotlin
data class DnsResult(val target: String, val ttl: Long)
val sources = listOf<DnsResult>(/* ... */)
val destinations = listOf<DnsResult>(/* ... */)
```

--

- Solution:

```kotlin
val minTtl = (sources + destinations).map { it.ttl }.min()
```

---

template: heading
# And Lots More ...

---

# Advanced Topics

- Coroutines
- Inline functions
- Generics, Covariance, Reified
- Type Safe Builders
- Lazy initialization
- Operator overloading
- Java Interop: Platform Types
- Scoping Functions: `let`, `run`, `apply`, `also`
- Kotlin.js

---

template: heading
# Java to Kotlin - By Example

Example using Open Source project: Floodlight

Conversion tooling (IntelliJ)

---

```java
Collection<IFloodlightModule> mods = serviceMap.get(s);
if (mods == null) {
    mods = new ArrayList<IFloodlightModule>();
    serviceMap.put(s, mods);
}
mods.add(m);
int dupInConf = 0;
for (IFloodlightModule cMod : mods) {
    if (mList.contains(cMod.getClass().getCanonicalName()))
        dupInConf += 1;
}
if (dupInConf > 1) {
    StringBuilder sb = new StringBuilder();
    for (IFloodlightModule mod : mods) {
        sb.append(mod.getClass().getCanonicalName());
        sb.append(", ");
    }
    String duplicateMods = sb.toString();
    String mess = "ERROR! The configuration file " +
            "specifies more than one module that " +
            "provides the service " +
            s.getCanonicalName() +
            ". Please specify only ONE of the " +
            "following modules in the config file: " +
            duplicateMods;
    throw new FloodlightModuleException(mess);
}
```

---

- Java

```java
Collection<IFloodlightModule> mods = serviceMap.get(s);
if (mods == null) {
    mods = new ArrayList<IFloodlightModule>();
    serviceMap.put(s, mods);
}
mods.add(m);
```

- Kotlin

```kotlin
val mods = serviceMap.getOrPut(s) { mutableListOf() }
mods.add(m)
```

---

- Java

```java
int dupInConf = 0;
for (IFloodlightModule cMod : mods) {
    if (mList.contains(cMod.getClass().getCanonicalName()))
        dupInConf += 1;
}
if (dupInConf > 1) {
    //...
}
```

- Kotlin

```kotlin
val intersection = mList.intersect(mods.map {
    it.javaClass.canonicalName
})
if (intersection.isNotEmpty()) {
    //...
}
```

---

- Java

```java
StringBuilder sb = new StringBuilder();
for (IFloodlightModule mod : mods) {
    sb.append(mod.getClass().getCanonicalName());
    sb.append(", ");
}
String duplicateMods = sb.toString();
String mess = "ERROR! The configuration file " +
        "specifies more than one module that " +
        "provides the service " +
        s.getCanonicalName() +
        ". Please specify only ONE of the " +
        "following modules in the config file: " +
        duplicateMods;
throw new FloodlightModuleException(mess);
```

- Kotlin

```kotlin
throw FloodlightModuleException("""ERROR! The configuration file
    |specifies more than one module that provides the service
    |${s.canonicalName}. Please specify only ONE of the following
    |modules in the config file: ${mods.joinToString(", ")}"""
    .trimMargin())
```

---

# Kotlin Result

```kotlin
val mods = serviceMap.getOrPut(s) { mutableListOf() }
mods.add(m)

val intersection = mList.intersect(mods.map {
    it.javaClass.canonicalName
})
if (intersection.isNotEmpty()) {
    throw FloodlightModuleException("""ERROR! The configuration file
        |specifies more than one module that provides the service
        |${s.canonicalName}. Please specify only ONE of the following
        |modules in the config file: ${mods.joinToString(", ")}"""
        .trimMargin())
}
```