object Plugins {

    /*
       Project Level
    */
    const val GRADLE = "com.android.tools.build:gradle"

    const val DETEKT = "io.gitlab.arturbosch.detekt"
    const val KTLINT = "org.jlleitschuh.gradle.ktlint"

    const val CLASSPATH_GRADLE = "com.android.tools.build:gradle:${PluginVersion.GRADLE_VERSION}"
    const val CLASSPATH_KTLINT =
        "org.jlleitschuh.gradle:ktlint-gradle:${PluginVersion.KTLINT_VERSION}"


    /*
        Module Level
     */
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_DYNAMIC_FEATURE = "com.android.dynamic-feature"
    const val ANDROID_LIBRARY = "com.android.library"

    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
    const val KOTLIN_KAPT = "kotlin-kapt"
}


