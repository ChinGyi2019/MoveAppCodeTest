import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.androidXNavigation(){
    implementation(AndroidXNavigation.fragment_ktx)
    implementation(AndroidXNavigation.ui_ktx)

}
object AndroidXNavigation{
    private const val version = "2.3.0"

    const val common = "androidx.navigation:navigation-common:$version"
    const val common_ktx = "androidx.navigation:navigation-common-ktx:$version"
    const val fragment = "androidx.navigation:navigation-fragment:$version"
    const val fragment_ktx = "androidx.navigation:navigation-fragment-ktx:$version"

    const val ui_ktx = "androidx.navigation:navigation-ui-ktx:$version"
}