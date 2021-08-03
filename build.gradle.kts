
plugins {
    id(KtLint.name) version KtLint.version
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript{

    val kotlin_version by extra("1.4.10")
    val hilt_version by extra("2.35")
    repositories {
        maven("https://plugins.gradle.org/m2/")
        google()
        mavenCentral()
        maven("https://jitpack.io")
        //  jcenter()
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }
    dependencies {

        classpath(CommonLibs.android_gradle_plugin)
        classpath(Kotlin.gradle_plugin)
        classpath(DaggerHilt.daggerHiltGradle)
        classpath ("com.google.dagger:hilt-android-gradle-plugin:$hilt_version")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")

    }
}
allprojects {
    repositories {
        maven("https://plugins.gradle.org/m2/")
        google()
        mavenCentral()
        maven("https://jitpack.io")
        //jcenter()
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
