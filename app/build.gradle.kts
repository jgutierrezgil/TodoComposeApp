plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    // Para utilizar Kapt si usas Room con anotaciones
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.novasolutions.todocomposeapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.novasolutions.todocomposeapp"
        minSdk = 24
        targetSdk = 35
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

        debug {
            plugins.withId("org.jetbrains.kotlin.kapt") {
                // kapt configurattion for debug
            }
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    //Jetpack Compose UI
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.ui:ui-tooling")


    //Lifecycle  y ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose")


    // Room
    implementation("androidx.room:room-runtime:<version>")
    implementation(libs.androidx.room.common)
    kapt("androidx.room:room-compiler:<version>")

    // Optativo para usar Coroutines con Room
    implementation("androidx.room:room-ktx:<version>")


    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:<version>")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:<version>")

    // Navigation Compose (opcional)
    implementation("androidx.navigation:navigation-compose:<version>")


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}