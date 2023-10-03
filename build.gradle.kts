// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(Dependencies.Classpath.navigationClasspath)
        classpath(Dependencies.Classpath.toolsBuildClasspath)
        classpath(Dependencies.Classpath.googleServiceClasspath)
        classpath(Dependencies.Classpath.kotlinSerializationClasspath)
//        classpath("com.google.dagger:hilt-android-gradle-plugin:2.46.1")

    }
}


plugins {
    id(Plugins.ANDROID_APPLICATION) version PluginsVersions.ANDROID_APPLICATION apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id(Plugins.ANDROID_LIBRARY) version PluginsVersions.ANDROID_LIBRARY apply false
    id(Plugins.KOTLIN_JVM) version PluginsVersions.KOTLIN_JVM apply false
    kotlin(Plugins.PLUGIN_SERIALIZATION) version PluginsVersions.PLUGIN_SERIALIZATION
    id(Plugins.HILT_LIBRARY) version PluginsVersions.HILT_LIBRARY apply false
    kotlin("kapt") version "1.9.0"
}