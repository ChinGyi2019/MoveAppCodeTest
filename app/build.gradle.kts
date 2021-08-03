plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id(KtLint.name)
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.chingyi.testproject"
        minSdkVersion(BuildConfig.minSdk)
        targetSdkVersion(BuildConfig.targetSdk)
        versionCode = BuildConfig.versionCode
        versionName = BuildConfig.versionName


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
    }
    buildFeatures.dataBinding = true
    buildTypes {
        getByName("release") {
            isDebuggable = true
            isMinifyEnabled = false
            buildConfigField("String", "APP_SECRET", "\"6033aa70d5ad0e5b102080e967d87740\"")
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            versionNameSuffix = "-debug"
            applicationIdSuffix = ".debug"
            isMinifyEnabled = false

            buildConfigField("String", "APP_SECRET", "\"6033aa70d5ad0e5b102080e967d87740\"")
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packagingOptions{
//        pickFirst ("META-INF/*")
        pickFirst ("META-INF/LICENSE")
        pickFirst ("META-INF/io.netty.versions.properties")
        pickFirst ("META-INF/INDEX.LIST")
        pickFirst ("META-INF/common_debug.kotlin_module")
        exclude( "META-INF/MANIFEST.MF" )

    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    kapt {
        javacOptions {
            // These options are normally set automatically via the Hilt Gradle plugin, but we
            // set them manually to workaround a bug in the Kotlin 1.5.20
            option("-Adagger.fastInit=ENABLED")
            option("-Adagger.hilt.android.internal.disableAndroidSuperclassValidation=true")
        }
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //Kotlin
    implementation(Kotlin.stdblib_jdk)
    implementation(KotlinCoroutine.android)
    implementation(AndroidXCore.core_ktx)
    //material
    implementation(Material.material)
    //Constraints
    implementation(AndroidXConstraintLayout.constraint_layout)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")



    androidXActivity()
    androidXFrament()
    androidXNavigation()
    androidXArch()

    //Networking
    implementation(OkHttp.client)
    implementation(OkHttp.logger)

    implementation(Retrofit.core)
    implementation(Retrofit.moshi_converter)
    moshi()

    //Room
    implementation(Room.ktx)
    implementation(Room.runtime)
    kapt(Room.compiler)


//    implementation(AndroidXViewPager.view_pager_2)
//    implementation(AndroidXViewPager.view_pager)
    implementation(AndroidXRecyclerView.recycler_view)

    //Timber
    implementation(CommonLibs.timber){
        exclude ("org.jetbrains")
    }
    //Coil
    implementation(Coil.coil)
    //Slider Image
    implementation(ImageSlider.imageSlider)

    //Dagger
    daggerHiltWithViewModel()
    //Test
    testImplementation(CommonLibs.junit)
    androidTestImplementation(AndroidXTestExt.junit)
    androidTestImplementation(AndroidXTestExt.expresso)
}

ktlint {
    android.set(true)
}


//implementation("androidx.appcompat:appcompat:1.3.0")
//implementation("com.google.android.material:material:1.3.0")
//implementation("androidx.constraintlayout:constraintlayout:2.0.1")
//implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
//implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
//implementation("androidx.navigation:navigation-fragment-ktx:2.3.0")
//implementation("androidx.navigation:navigation-ui-ktx:2.3.0")
//implementation("androidx.legacy:legacy-support-v4:1.0.0")
