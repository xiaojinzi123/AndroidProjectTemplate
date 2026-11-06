plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.ksp)
}

android {
    namespace = "com.xiaojinzi.module.base"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}

ksp {
    arg("ModuleName", "module-base")
}

dependencies {

    api(project(":lib-res"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    api(libs.component.core)
    ksp(libs.component.compiler)

    api(libs.androidx.core.ktx)
    api(libs.androidx.lifecycle.runtime.ktx)
    api(libs.androidx.activity.compose)
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.ui)
    api(libs.androidx.ui.graphics)
    api(libs.androidx.ui.tooling.preview)
    api(libs.androidx.material3)
    api(libs.compose.material.icons.core)

    api(libs.coil.compose)
    api(libs.coil.svg)
    api(libs.coil.gif)
    api(libs.coil.video)

    api(libs.lottie.compose)

    api(libs.xiaojinzi.android.support.init)
    api(libs.xiaojinzi.android.support.bean)
    api(libs.xiaojinzi.android.support.ktx)
    api(libs.xiaojinzi.android.support.activitystack)
    api(libs.xiaojinzi.android.support.compose)

    // api(libs.xiaojinzi.android.module.ffmpeg)

    api(libs.xiaojinzi.android.module.storage)
    api(libs.xiaojinzi.android.module.ffmpeg)
    api(libs.xiaojinzi.android.module.ali.oss)
    api(libs.xiaojinzi.android.module.ali.pay)
    api(libs.xiaojinzi.android.module.wx.sdk)

    api(libs.xiaojinzi.android.reactive.core)
    api(libs.xiaojinzi.android.reactive.template)
    api(libs.xiaojinzi.android.reactive.template.compose)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

}