plugins {
    application
    kotlin("jvm") version "1.2.31"
}

dependencies {
    compile(kotlin("stdlib"))
    compile("floodlight:floodlight:1.2")
}

repositories {
    jcenter()
}
 