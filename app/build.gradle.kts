plugins {

    // 🔥 Groovy DSL
//    id 'com.android.application'
//    id 'kotlin-android'

    // 🔥 Kotlin DSL
//    id("com.android.application")
//    kotlin("android")

    // 🔥 Kotlin DSL with BuildSrc
    id(Plugins.ANDROID_APPLICATION_PLUGIN)
    id(Plugins.KOTLIN_ANDROID_PLUGIN)
    id(Plugins.KOTLIN_ANDROID_EXTENSIONS_PLUGIN)
    id(Plugins.KOTLIN_KAPT_PLUGIN)
    id(Plugins.DAGGER_HILT_PLUGIN)
}

android {

    // 🔥 Groovy DSL
//    compileSdkVersion 29
//    buildToolsVersion "30.0.0"
//
//    defaultConfig {
//        applicationId "com.smarttoolfactory.staticcodeanalysis"
//        minSdkVersion 21
//        targetSdkVersion 29
//        versionCode 1
//        versionName "1.0"
//
//        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }
//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = '1.8'
//    }

    // 🔥 Kotlin DSL

    compileSdkVersion(AndroidVersion.COMPILE_SDK_VERSION)
    defaultConfig {
        applicationId = "com.smarttoolfactory.staticcodeanalysis"
        minSdkVersion(AndroidVersion.MIN_SDK_VERSION)
        targetSdkVersion(AndroidVersion.TARGET_SDK_VERSION)
        versionCode = AndroidVersion.VERSION_CODE
        versionName = AndroidVersion.VERSION_NAME
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Deps.KOTLIN)
    implementation(Deps.ANDROIDX_CORE_KTX)

    // Support and Widgets
    implementation(Deps.APPCOMPAT)
    implementation(Deps.MATERIAL)
    implementation(Deps.CONSTRAINT_LAYOUT)
    implementation(Deps.RECYCLER_VIEW)
    implementation(Deps.VIEWPAGER2)

    // Lifecycle, LiveData, ViewModel
    implementation(Deps.ARCH_LIFECYCLE)

    // Navigation Components
    implementation(Deps.NAVIGATION_FRAGMENT)
    implementation(Deps.NAVIGATION_UI)
    implementation(Deps.NAVIGATION_RUNTIME)
    implementation(Deps.NAVIGATION_DYNAMIC)

    // Dagger
    implementation(Deps.DAGGER_HILT_ANDROID)
    kapt(Deps.DAGGER_HILT_COMPILER)

    // Room
    implementation(Deps.ROOM_RUNTIME)
    // For Kotlin use kapt instead of annotationProcessor
    kapt(Deps.ROOM_COMPILER)
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(Deps.ROOM_KTX)
    // optional - RxJava support for Room
    implementation(Deps.ROOM_RXJAVA2)

    // RxJava
    implementation(Deps.RX_JAVA)
    // RxAndroid
    implementation(Deps.RX_ANDRIOD)

    // Coroutines
    implementation(Deps.COROUTINES_CORE)
    implementation(Deps.COROUTINES_ANDROID)

    // Retrofit
    implementation(Deps.RETROFIT)
    implementation(Deps.RETROFIT_GSON_CONVERTER)
    implementation(Deps.RETROFIT_RX_JAVA2_ADAPTER)
    // change base url runtime
    implementation(Deps.RETROFIT_URL_MANAGER)
    // Gson
    implementation(Deps.GSON)

    // **** TESTING ****
    /*
        Unit Tests
     */
//     (Required) Writing and executing Unit Tests on the JUnit Platform
    testImplementation(TestDeps.JUNIT5_API)
    testRuntimeOnly(TestDeps.JUNIT5_ENGINE)

    // (Optional) If you need "Parameterized Tests"
    testImplementation(TestDeps.JUNIT5_PARAM)

    testImplementation(TestDeps.ANDROIDX_CORE_TESTING)
    testImplementation(TestDeps.ROBOELECTRIC)

    // AndroidX Test - JVM testing
//    testImplementation(TestDeps.ANDRIODX_CORE_KTX)
//    testImplementation(TestDeps.ANDROIDX_JUNIT)

    // MockK
    testImplementation(TestDeps.MOCK_K)
    // Truth
    testImplementation(TestDeps.TRUTH)

    /*
        Instrumented Tests
     */
    // AndroidX Test - Instrumented testing
    androidTestImplementation(TestDeps.ANDROIDX_JUNIT)
    // Espresso
    androidTestImplementation(TestDeps.ANDROIDX_ESPRESSO)
    // MockK
    androidTestImplementation(TestDeps.MOCK_K)
    // Testing Navigation
    androidTestImplementation(TestDeps.NAVIGATION_TEST)
}
