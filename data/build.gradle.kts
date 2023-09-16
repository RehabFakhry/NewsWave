import java.util.Properties
plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.HILT_LIBRARY)
    id(Plugins.SERIALIZATION)
    kotlin(Plugins.KOTLIN_ANDROID)
    kotlin(Plugins.KOTLIN_KAPT)
    id ("com.google.gms.google-services")

}

val localProps = Properties()
val localPropsFile = localProps.load(project.rootProject.file("local.properties").inputStream())

android {
    namespace = "com.the_chance.data"
    compileSdk = ConfigData.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = ConfigData.MIN_SDK_VERSION

        buildConfigField("String", "API_KEY", localProps.getProperty("API_KEY"))

        testInstrumentationRunner = ConfigData.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        getByName(BuildType.RELEASE){
            isMinifyEnabled =BuildTypeRelease.isMinifyEnabled
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
}

dependencies {

    implementation(project(BuildModules.DOMAIN))
    Dependencies.uiDependencies.forEach { implementation(it) }
    testImplementation(Dependencies.junitDependency)
//    Dependencies.androidTestDependencies.forEach { androidTestImplementation(it) }
    //retrofit
    Dependencies.retrofitDependencies.forEach { implementation(it) }
    //Coroutine
    implementation(Dependencies.coroutinesDependency)
    //Hilt
    implementation(Dependencies.hiltDependency)
    kapt(Dependencies.hiltCompiler)
//    implementation(Dependencies.hiltCompiler)
    implementation(Dependencies.daggerAndroid)
//    implementation ("com.google.firebase:firebase-auth:22.1.1")
    implementation ("com.google.firebase:firebase-auth-ktx:22.1.1")
    implementation ("com.google.firebase:firebase-auth:22.1.1")

}