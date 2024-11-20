plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    id ("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp") version "2.0.0-1.0.21"

}

android {
    namespace = "com.example.recipeapp_android"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.recipeapp_android"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    val room_version = "2.6.1"
    // Room - Library for data persistence (simplified SQLite database)
    implementation("androidx.room:room-runtime:$room_version") // Main Room dependency to manage the database
    kapt("androidx.room:room-compiler:$room_version") // Room compiler to generate code for annotations like @Entity and @Dao
    implementation("androidx.room:room-ktx:$room_version") // Kotlin extensions to simplify asynchronous operations with Room

    // Retrofit - Library for network calls (REST API)
    implementation("com.squareup.retrofit2:retrofit:2.11.0") // Main Retrofit dependency for making HTTP requests
    implementation("com.squareup.retrofit2:converter-gson:2.11.0") // Gson converter to serialize and deserialize JSON automatically

    // Coil - Library for image loading
    implementation("io.coil-kt:coil-compose:2.0.0") // Coil with support for Jetpack Compose, to efficiently load images

    // Hilt - Library for Dependency Injection (DI)
    implementation("com.google.dagger:hilt-android:2.51.1") // Main Hilt library for dependency injection in Android
    ksp("com.google.dagger:hilt-compiler:2.51.1") // Hilt compiler to generate code for dependency injection
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0") // Support for navigation in Jetpack Compose with Hilt

    // Lifecycle - Manage lifecycle-aware components (e.g., ViewModel)
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.5") // Integration between ViewModel and Jetpack Compose

    // Navigation - Library for screen navigation
    implementation("androidx.navigation:navigation-compose:2.7.7") // Declarative navigation for Jetpack Compose

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}