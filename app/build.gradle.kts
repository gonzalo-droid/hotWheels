plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.gradle.plugin)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

android {
    namespace = "com.gondroid.wheelsteam"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.gondroid.wheelsteam"
        minSdk = 25
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)

    // Material 3
    implementation(libs.androidx.material3)
    implementation("androidx.compose.material:material:1.7.5")
    //Navigation Compose
    implementation(libs.androidx.navigation.compose)
    //Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.ui.text.google.fonts)
    ksp(libs.hilt.compiler)
    ksp(libs.dagger.compiler)
    //Coil3
    implementation(libs.coil.compose)
    implementation(libs.coil.compose.core)
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)
    //Moshi
    implementation(libs.moshi)
    ksp(libs.moshi.codegen)
    implementation(libs.moshi.kotlin)
    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.moshi)
    //OkHttp
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    //Room
    implementation(libs.room)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    //Kotlinx Serialization
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}