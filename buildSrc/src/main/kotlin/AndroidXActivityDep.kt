import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.androidXActivity(){
   implementation(AndroidXActivityDep.activity_ktx)
}
object AndroidXActivityDep {

        private const val version = "1.2.0-alpha05"
        const val activity = "androidx.activity:activity:$version"
        const val activity_ktx = "androidx.activity:activity-ktx:$version"

}