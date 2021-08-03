import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.androidXArch() {
    implementation(androidXArchCore.common)
    implementation(androidXArchLifeCycle.view_model)
    implementation(androidXArchLifeCycle.live_data)
    implementation(androidXArchLifeCycle.extensions)

}
object androidXArchLifeCycle{
    private const val version = "2.3.0-beta01"
    const val view_model = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    const val live_data = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
    const val extensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
}
object androidXArchCore {
 const val version = "2.1.0"
    const val common = "androidx.arch.core:core-common:$version"
}
