package com.chrisdail.slides

val emptyList = emptyList<String>()
val list = listOf(1, 1, 2, 3)
val mutableList = mutableListOf<String>()
mutableList.add("hello")

println(list + listOf(5, 8))
// [1, 1, 2, 3, 5, 8]

println(setOf(1, 1, 2, 3))
// [1, 2, 3]

val emptyMap = emptyMap<String,String>()
val map = mapOf("a" to 1, "b" to 2, "c" to 3)
println(map["b"])
// 2
val mutableMap = mutableMapOf<String,String>()
mutableMap["hello"] = "world"




data class DnsResult(val target: String, val ttl: Long)

val sources = listOf<DnsResult>(
    DnsResult("1.2.3.4", 3600),
    DnsResult("192.168.3.7", 450),
    DnsResult("10.3.1.76", 3600)
)
val destinations = listOf<DnsResult>(
    DnsResult("10.11.33.102", 10000)
)
val minTtl = (sources + destinations).map { it.ttl }.min()
println(minTtl)
