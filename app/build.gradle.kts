plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.KOTLIN_ANDROID)
    kotlin(Plugins.KOTLIN_KAPT)
    id(Plugins.HILT_LIBRARY)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.the_chance.newswave"
    compileSdk = ConfigData.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = "com.the_chance.newswave"
        minSdk = ConfigData.MIN_SDK_VERSION
        targetSdk = ConfigData.TARGET_SDK_VERSION
        versionCode = ConfigData.VERSION_CODE
        versionName = ConfigData.VERSION_NAME

        testInstrumentationRunner = ConfigData.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
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
//    composeOptions {
//        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
//    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//            excludes += "META-INF/gradle/incremental.annotation.processors"

        }
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
    androidTestImplementation(platform(Dependencies.composePlatformBomAndroidTest))
    Dependencies.androidTestDependencies.forEach { androidTestImplementation(it) }
    debugImplementation(Dependencies.composeUiDependency)
    Dependencies.debugmplementation.forEach { debugImplementation(it)}
        kapt(Dependencies.hiltCompiler)
//    implementation(Dependencies.hiltCompiler)
    implementation(Dependencies.hiltDependency)
}