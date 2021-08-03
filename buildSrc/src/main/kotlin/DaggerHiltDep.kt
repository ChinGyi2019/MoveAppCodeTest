import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.daggerHiltWithViewModel(){
    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.daggerHiltCompiler)
   // implementation(DaggerHilt.hiltViewModel)
    kapt(DaggerHilt.hiltCompiler)

}

fun DependencyHandler.daggerHiltJvm() {
    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.daggerHiltCompiler)
    kapt(DaggerHilt.hiltCompiler)
}
fun DependencyHandler.daggerPureJvm() {
    implementation(DaggerHilt.core)
    kapt(DaggerHilt.daggerCompiler)
}
object DaggerHilt{
    private const val version = "2.35"
    //Gradle
    const val daggerHiltGradle = "com.google.dagger:hilt-android-gradle-plugin:$version"
    //Core
    const val core = "com.google.dagger:dagger:$version"
    const val daggerCompiler =  "com.google.dagger:dagger-compiler:$version"
    //Hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:$version"
    const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:$version"

    const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"
  //  const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0"

}