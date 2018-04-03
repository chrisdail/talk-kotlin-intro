package com.chrisdail.slides

var message = "Hello World!"
println(message)

var planet = "Earth"
println("Hello $planet")
println("HELLO ${planet.toUpperCase()}")

var multilineString = """
    |{
    |    "message": "test"
    |}
""".trimMargin()
println(multilineString)

val (last, first) = "Bond, James".split(", ")
println("$last. $first $last.")

val (_, prefix, suffix) = "506-555-1212".split("-")
println("Making Local call to $prefix-$suffix")
