@file:Suppress("DEPRECATION")

import java.io.FileInputStream
import java.util.Properties

val keystorePropertiesFile = rootProject.file("keystore.properties")
val keystoreProperties = Properties()

if (keystorePropertiesFile.exists()) {
    keystoreProperties.load(FileInputStream(keystorePropertiesFile))
}

plugins {
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.android.application)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.serialization.compiler)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.firebase-perf")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.emanh.flashcard.topicenglish"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.emanh.flashcard.topicenglish"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = listOf("-XXLanguage:+PropertyParamAnnotationDefaultTargetMode")
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    packaging {
        resources {
            excludes += listOf("META-INF/DEPENDENCIES",
                               "META-INF/LICENSE",
                               "META-INF/LICENSE.txt",
                               "META-INF/NOTICE",
                               "META-INF/NOTICE.txt",
                               "META-INF/INDEX.LIST")
        }
    }
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso)
    androidTestImplementation(platform(libs.androidx.compose.bom))

    debugImplementation(libs.bundles.debug.implementation.compose.ui)

    annotationProcessor(libs.glide.compiler)
    annotationProcessor(libs.androidx.room.compiler)

    kapt(libs.bundles.kapt.hilt)
    ksp(libs.androidx.room.compiler)

    implementation(libs.timber)
    implementation(libs.lottie.compose)
    implementation(libs.design.material)
    implementation(libs.google.play.services.location)

    implementation(libs.bundles.room)
    implementation(libs.bundles.coil)
    implementation(libs.bundles.glide)
    implementation(libs.bundles.androidx)
    implementation(libs.bundles.firebase)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.navigation)
    implementation(libs.bundles.network.api)
    implementation(libs.bundles.serialization)
    implementation(libs.bundles.implementation.hilt)
    implementation(libs.bundles.implementation.compose)

    implementation(platform(libs.okhttp.bom))
    implementation(platform(libs.firebase.bom))
    implementation(platform(libs.androidx.compose.bom))
}