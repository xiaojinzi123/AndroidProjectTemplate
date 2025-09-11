import com.android.build.gradle.internal.scope.ProjectInfo.Companion.getBaseName

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.ksp)
}

android {
    namespace = "com.xiaojinzi.module.base"
    compileSdk = 35

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
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlin.compiler.extension.get()
    }
}

ksp {
    arg("ModuleName", "module-base")
}

dependencies {

    api(project(":lib-res"))

    testApi(libs.junit)
    androidTestApi(libs.androidx.junit)
    androidTestApi(libs.androidx.espresso.core)
    androidTestApi(platform(libs.androidx.compose.bom))
    androidTestApi(libs.androidx.ui.test.junit4)
    debugApi(libs.androidx.ui.tooling)
    debugApi(libs.androidx.ui.test.manifest)

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

    testApi(libs.junit)

    androidTestApi(libs.androidx.junit)
    androidTestApi(libs.androidx.espresso.core)
    androidTestApi(platform(libs.androidx.compose.bom))
    androidTestApi(libs.androidx.ui.test.junit4)
    debugApi(libs.androidx.ui.tooling)
    debugApi(libs.androidx.ui.test.manifest)

}