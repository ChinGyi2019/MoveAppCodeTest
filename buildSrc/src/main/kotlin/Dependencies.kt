object BuildConfig {
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30

    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0
    private const val versionBuild = 1

    const val versionName =
        "$versionMajor.$versionMinor.$versionPatch"
    const val versionCode =
        versionMajor*1000000 + versionMinor * 10000 + versionPatch * 100 + versionBuild

}

object CommonLibs {
    const val android_gradle_plugin = "com.android.tools.build:gradle:4.2.2"

    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val junit = "junit:junit:4.13"
    const val javaxInject = "javax.inject:javax.inject:1"

}

object AndroidXTestExt {
    private const val version = "1.1.2"

    const val junit = "androidx.test.ext:junit:$version"
    const val junit_ktx = "androidx.test.ext:junit-ktx:$version"
    const val truth = "androidx.test.ext:truth:1.3.0"
    const val expresso = "androidx.test.espresso:espresso-core:3.3.0"
}
//android Region
object AndroidXAppCompat {
    const val app_compat = "androidx.appcompat:appcompat:1.3.0-alpha02"
}

object AndroidXRecyclerView {
    private const val version = "1.2.0-alpha06"

    const val recycler_view = "androidx.recyclerview:recyclerview:$version"
    const val selection = "androidx.recyclerview:recyclerview-selection:$version"
}

object AndroidXCardView {
    const val card_view = "androidx.cardview:cardview:1.0.0"
}

object AndroidXConstraintLayout {
    private const val version = "2.0.0"

    const val constraint_layout = "androidx.constraintlayout:constraintlayout:$version"
}

object AndroidXViewPager {
    const val view_pager = "androidx.viewpager:viewpager:1.0.0"

    const val view_pager_2 = "androidx.viewpager2:viewpager2:1.1.0-alpha01"
}

object AndroidXCore {
    private const val version = "1.6.0"

    const val core = "androidx.core:core:$version"
    const val core_ktx = "androidx.core:core-ktx:$version"
}

object AndroidXPaging {
    private const val version = "3.0.0-alpha07"

    const val common = "androidx.paging:paging-common:$version"
    const val runtime = "androidx.paging:paging-runtime:$version"
}

//end region
object Material {
    const val material = "com.google.android.material:material:1.3.0"
}

object Kotlin {
    private const val version = "1.4.10"

    const val stdblib_jdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
    const val gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
}

object KtLint {
    const val version = "9.3.0"
    const val name = "org.jlleitschuh.gradle.ktlint"

    const val plugin = "org.jlleitschuh.gradle:ktlint-gradle:$version"
}

object KotlinCoroutine {
    private const val version = "1.4.3"

    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    const val adapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
    const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
}

object Retrofit {
    private const val version = "2.9.0"

    const val core = "com.squareup.retrofit2:retrofit:$version"
    const val moshi_converter = "com.squareup.retrofit2:converter-moshi:$version"
}
object RxJava{
    // RxJava
    private const  val  rx_android_version = "2.1.1"
    private const val rxjava_version = "2.2.13"
    private const val rx_kotlin_version = "2.4.0"

    const val rx_android = "io.reactivex.rxjava2:rxandroid:$rx_android_version"
    const val rxjava = "io.reactivex.rxjava2:rxjava:$rxjava_version"
    const val rx_kotlin = "io.reactivex.rxjava2:rxkotlin:$rx_kotlin_version"

}

object Scarlet {
    private const val version ="0.2.4"

    const val scarlet = "com.github.tinder.scarlet:scarlet:$version"
    const val scarlet_rxjava =
            "com.github.tinder.scarlet:scarlet-stream-adapter-rxjava2:$version"
    const val scarlet_websocket =
            "com.github.tinder.scarlet:scarlet-protocol-websocket-okhttp:$version"
    const val scarlet_moshi =
            "com.github.tinder.scarlet:scarlet-message-adapter-moshi:$version"
    const val scarlet_lifecycle =
            "com.github.tinder.scarlet:scarlet-lifecycle-android:$version"
   // const val scarlet_okhttp =
     //   "com.tinder.scarlet:protocol-websocket-okhttp:$version"
//    const val scarlet_coroutines =
//        "com.tinder.scarlet:stream-adapter-coroutines:$version"
}

object OkHttp {
    private const val version = "4.9.0"

    const val client = "com.squareup.okhttp3:okhttp:$version"
    const val logger = "com.squareup.okhttp3:logging-interceptor:$version"
    const val mock_web_server = "com.squareup.okhttp3:mockwebserver:$version"
}

object Room{
    private const val version = "2.3.0"
    const val compiler = "androidx.room:room-compiler:$version"
    const val ktx = "androidx.room:room-ktx:$version"
    const val runtime = "androidx.room:room-runtime:$version"
}


object Coil {
    const val coil = "io.coil-kt:coil:1.0.0-rc3"
}


object ImageSlider{
    private const val version = "1.4.0"
    const val  imageSlider= "com.github.smarteist:autoimageslider:$version"

}