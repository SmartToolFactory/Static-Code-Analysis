// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        jcenter()

        // 🔥 Groovy DSL
        //        maven {url "https://plugins.gradle.org/m2/"}

        // 🔥 Kotlin DSL
        maven { url = uri("https://plugins.gradle.org/m2/") }
    }

    // 🔥 Groovy DSL
//    dependencies {
//        classpath "com.android.tools.build:gradle:4.1.0-beta04"
//        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
//
//        // NOTE: Do not place your application dependencies here; they belong
//        // in the individual module build.gradle files
//
//        classpath "org.jlleitschuh.gradle:ktlint-gradle:9.3.0"
//
//    }

    val kotlinVersion = "1.3.72"

    // 🔥 Kotlin DSL
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.0-beta04")
        classpath(kotlin("gradle-plugin", version = "1.3.72"))

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files

        classpath("org.jlleitschuh.gradle:ktlint-gradle:9.3.0")
    }
}

plugins {
    id("org.jlleitschuh.gradle.ktlint").version("9.3.0")
}

allprojects {

    repositories {
        google()
        jcenter()
    }

    // 🔥 Groovy
//    apply plugin: "org.jlleitschuh.gradle.ktlint"
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
