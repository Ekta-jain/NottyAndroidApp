import com.hari.notty.buildsrc.Libs
import com.hari.notty.buildsrc.extensions.buildConfigBooleanField
import com.hari.notty.buildsrc.extensions.buildConfigIntField
import com.hari.notty.buildsrc.extensions.buildConfigStringField
import com.hari.notty.buildsrc.extensions.getLocalProperty

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("kotlinx-serialization")
}


android {
    compileSdk = 32
    defaultConfig {
        minSdk = 21
        targetSdk = 32

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes.forEach {
            it.buildConfigStringField("NOTTY_API_BASE_URL", "https://whispering-inlet-78398.herokuapp.com/")
            it.buildConfigBooleanField("NOTTY_DATABASE_EXPORT_SCHEMA", false)
            it.buildConfigStringField("NOTTY_DATABASE_NAME", "notty-db")
            it.buildConfigIntField("NOTTY_DATABASE_VERSION", 1)
    }

    packagingOptions {
        exclude ("META-INF/licenses/**")
        exclude ("META-INF/AL2.0")
        exclude ("META-INF/LGPL2.1")
        exclude ("META-INF/common.kotlin_module")
        exclude ("META-INF/*.kotlin_module")
    }
}

dependencies {
   /* implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.Lifecycle.extensions)*/


    /*DATABASE*/
    implementation(Libs.AndroidX.Room.runtime)
    implementation(Libs.AndroidX.Room.ktx)
    kapt(Libs.AndroidX.Room.compiler)

    /*NETWORK*/
    implementation(Libs.Network.retrofit)
    implementation(Libs.Network.gsonConverter)
    implementation(Libs.Network.okHttpBom)
    implementation(Libs.Network.okHttp)
    implementation(Libs.Network.loggingInterceptor)


    implementation (Libs.Ktor.core)
    implementation (Libs.Ktor.androidEngine)
    implementation (Libs.Ktor.contentNegotiation)
    implementation (Libs.Ktor.serialization)
    implementation (Libs.Ktor.jsonSerialization)
    implementation (Libs.Ktor.logging)


    /*DI*/
    implementation(Libs.AndroidX.Hilt.hilt)
    kapt(Libs.AndroidX.Hilt.compiler)


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}