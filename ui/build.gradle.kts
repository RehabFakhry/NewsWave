plugins {
    id("com.android.library")
//    id("org.jetbrains.kotlin.android")
//    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.KOTLIN_ANDROID)
    kotlin(Plugins.KOTLIN_KAPT)
    id(Plugins.HILT_LIBRARY)
    id(Plugins.NAVIGATION_ARGS)
}

android {
    namespace = "com.the_chance.ui"
    compileSdk = 33

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = ConfigData.JAVA_VERSIONS_CODE
        targetCompatibility = ConfigData.JAVA_VERSIONS_CODE
    }
    kotlinOptions {
        jvmTarget = ConfigData.JAVA_VERSIONS_CODE.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {

    implementation(project(BuildModules.DOMAIN))
    implementation(project(BuildModules.DATA))

    Dependencies.uiDependencies.forEach { implementation(it) }
    Dependencies.retrofitDependencies.forEach { implementation(it) }
    Dependencies.composeDependency.forEach { implementation(it) }
    implementation(platform(Dependencies.composePlatformBom))
    implementation("androidx.compose.material3:material3")
    implementation("com.google.firebase:firebase-auth-ktx:22.1.1")
    testImplementation("junit:junit:4.13.2")
    Dependencies.navigationDependencies.forEach { implementation(it) }
    implementation(Dependencies.glideDependency)
    implementation(Dependencies.coilDependency)
    //navigation
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("androidx.navigation:navigation-compose:2.6.0")
    androidTestImplementation(Dependencies.composePlatformBomAndroidTest)
    Dependencies.androidTestDependencies.forEach { androidTestImplementation(it) }
    debugImplementation(Dependencies.composeUiDependency)
    Dependencies.debugmplementation.forEach { debugImplementation(it)}
    kapt(Dependencies.hiltCompiler)
    implementation(Dependencies.hiltDependency)
}