import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    kotlin("jvm") version "1.4.32"
}

gradlePlugin {
    plugins {
        register("luminoso-build-plugin") {
            id = "luminoso-build-plugin"
            implementationClass = "com.luminoso.android.LuminosoBuildPlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:4.0.2")
    implementation(kotlin("stdlib-jdk8"))
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}