plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
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
    implementation("com.android.tools.build:gradle:4.1.2")
}