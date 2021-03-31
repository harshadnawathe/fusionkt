plugins {
    kotlin("jvm") version "1.4.32"
}

group = "com.github.harshadnawathe"
version = "0.1-SNAPSHOT"

val kotestVersion = "4.4.3"
val junit5Version = "5.7.1"

repositories {
    mavenCentral()
}
dependencies {
    implementation(kotlin("stdlib"))

    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit5Version")
}

tasks.withType<Test> {
    useJUnitPlatform()
}