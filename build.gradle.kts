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
    id("org.jlleitschuh.gradle.ktlint") version "9.3.0"
    id("io.gitlab.arturbosch.detekt") version "1.10.0"
}

allprojects {
    repositories {
        google()
        jcenter()
    }
    // 🔥 Groovy
//    apply plugin: "org.jlleitschuh.gradle.ktlint"
}

subprojects {

    // KtLint
    apply(plugin = "org.jlleitschuh.gradle.ktlint") // Version should be inherited from parent

    // Optionally configure plugin
    ktlint {
        debug.set(true)
    }

    // Detekt
    apply(plugin = "io.gitlab.arturbosch.detekt")

    detekt {
        config = files("${project.rootDir}/config/detekt/detekt.yml")
        parallel = true
    }
}

// JVM target applied to all Kotlin tasks across all sub-projects
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
