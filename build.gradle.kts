// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    val kotlin_version by extra("1.3.72")
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

    // 🔥 Kotlin DSL
//    dependencies {
//        classpath("com.android.tools.build:gradle:4.1.0-beta04")
//        classpath(kotlin("gradle-plugin", version = "1.3.72"))
//        classpath("org.jlleitschuh.gradle:ktlint-gradle:9.3.0")
//    }

    // 🔥 Kotlin DSL + BuildSrc
    dependencies {
        classpath(Plugins.CLASSPATH_GRADLE)
        classpath(kotlin("gradle-plugin", version = PluginVersion.KOTLIN_VERSION))
        classpath(Plugins.CLASSPATH_DAGGER_HILT)
        classpath(Plugins.CLASSPATH_KTLINT)
    }
}

// plugins {
//    id("org.jlleitschuh.gradle.ktlint") version GradlePluginVersion.KTLINT_VERSION
//    id("io.gitlab.arturbosch.detekt") version GradlePluginVersion.DETEKT_VERSION
// }

plugins {
    id(Plugins.KTLINT) version PluginVersion.KTLINT_VERSION
    id(Plugins.DETEKT) version PluginVersion.DETEKT_VERSION
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
    apply(plugin = Plugins.KTLINT) // Version should be inherited from parent

    // Optionally configure plugin
    ktlint {
        debug.set(true)
    }

    // Detekt
    apply(plugin = Plugins.DETEKT)

    detekt {
        config = files("${project.rootDir}/config/detekt/detekt.yml")
        parallel = true

        reports {
            xml {
                enabled = true
                destination = file("${project.rootDir}/build/reports/detekt_report.xml")
            }
            html {
                enabled = true
                destination = file("${project.rootDir}/build/reports/detekt_report.html")
            }
            txt {
                enabled = true
                destination = file("${project.rootDir}/build/reports/detekt_report.txt")
            }
        }
    }
}

// JVM target applied to all Kotlin tasks across all sub-projects
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
