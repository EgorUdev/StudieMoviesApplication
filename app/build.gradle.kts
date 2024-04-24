plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.movies"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.movies"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.room)
    implementation(libs.glide)
    implementation(libs.retrofit)
    implementation(libs.rxJava)
    implementation(libs.rxAndroid)
    implementation(libs.gson)
    implementation(libs.rxJavaRetrofitAdapter)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.roomRxjava3)
    implementation(libs.constraintlayout)
    annotationProcessor(libs.roomCompiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}