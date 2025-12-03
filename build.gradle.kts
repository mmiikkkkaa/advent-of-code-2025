import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val junitVersion = "junit"
val assertjVersion = "3.21.0"
val kotlinpoetVersion = "2.2.0"

plugins {
    kotlin("jvm") version "2.2.20"
}

group = "net.mikka"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup:kotlinpoet:$kotlinpoetVersion")
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testImplementation("org.assertj:assertj-core:$assertjVersion")
}

tasks.withType<Test> {
//    useJUnitPlatform()
}

tasks.withType<KotlinCompile>().configureEach {
//    compilerOptions {
//        jvmTarget = "17"
//    }
}