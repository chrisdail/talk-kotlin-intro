package com.chrisdail.slides

var neverNull: String = "hi"
//neverNull = null   // Compilation Error
var message: String? = "hi"
message = null

message?.length
// Equivalent Java: (message == null) ? null : message.length

val length = message?.length ?: -1

val map = mapOf("name" to "Chris")
val name = map["name"] ?: throw IllegalArgumentException()