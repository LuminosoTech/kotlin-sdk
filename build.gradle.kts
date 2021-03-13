plugins {
    base
    kotlin("jvm") version "1.4.31" apply false
}
buildscript {
    val kotlin_version by extra("1.4.31")

    repositories {
        google()
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}


allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

subprojects {

//    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
//        println("Configuring $name in project ${project.name}...")
//        kotlinOptions {
//            jvmTarget = "1.8"
//            freeCompilerArgs = listOf("-Xjsr305=strict")
//        }
//    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
