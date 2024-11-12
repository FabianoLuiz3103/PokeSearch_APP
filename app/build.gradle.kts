plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.devtools.ksp")
}

android {
    namespace = "br.com.fabianoluiz.pokemonsearch"
    compileSdk = 35

    defaultConfig {
        applicationId = "br.com.fabianoluiz.pokemonsearch"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("androidx.room:room-runtime:2.6.1" )
    ksp("androidx.room:room-compiler:2.6.1" )
    implementation("androidx.room:room-ktx:2.6.1" )
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")
    implementation ("androidx.fragment:fragment-ktx:1.8.5" )
    implementation("androidx.activity:activity-ktx:1.9.3" )

    // ViewModel e LiveData
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7" )
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7" )
//Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0" )
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0" )
//Koin
    implementation ("io.insert-koin:koin-android:3.4.0" )
    implementation ("io.insert-koin:koin-core:3.4.0" )

    implementation ("com.github.bumptech.glide:glide:4.15.1")
}