buildscript {
    dependencies {
        classpath(libs.hilt.android.gradle.plugin)
        classpath(libs.firebase.classpath.crashlytics)
        classpath(libs.firebase.classpath.performance)
        classpath(libs.navigation.safe.args.gradle.plugin)
    }
}

plugins {
    alias(libs.plugins.kotlin.ksp) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.dagger.hilt.android) apply false
    alias(libs.plugins.google.playservices) apply false
    alias(libs.plugins.serialization.compiler) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}