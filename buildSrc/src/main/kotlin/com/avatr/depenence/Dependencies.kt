package com.avatr.depenence

object Dependencies {

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    const val androidAnnotation = "androidx.annotation:annotation:${Versions.androidAnnotation}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityVersion}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val androidCoreKtx = "androidx.core:core-ktx:${Versions.androidCoreKtx}"
    const val datastorePreferences = "androidx.datastore:datastore-preferences:${Versions.datastorePreferences}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}"
    const val kotlinTestJunit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlinVersion}"

    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"

    const val kotlinxSerializationCore =
        "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.serializationVersion}"
    const val kotlinxSerializationJson =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serializationVersion}"

    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common:${Versions.lifecycleVersion}"
    const val lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}"
    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycleVersion}"
    const val lifecycleLivedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val lifecycleProcess = "androidx.lifecycle:lifecycle-process:${Versions.lifecycleVersion}"
    const val lifecycleService = "androidx.lifecycle:lifecycle-service:${Versions.lifecycleVersion}"
    const val lifecycleViewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"

    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val recyclerviewSelection = "androidx.recyclerview:recyclerview-selection:${Versions.recyclerviewSelection}"

    const val koinCore = "io.insert-koin:koin-core:${Versions.koinCoreVersion}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koinAndroidVersion}"
    const val koinAndroidxNavigation = "io.insert-koin:koin-androidx-navigation:${Versions.koinAndroidVersion}"

    const val ktorAuth = "io.ktor:ktor-client-auth:${Versions.ktorVersion}"
    const val ktorContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktorVersion}"
    const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
    const val ktorGson = "io.ktor:ktor-client-gson:${Versions.ktorVersion}"
    const val ktorJson = "io.ktor:ktor-client-json:${Versions.ktorVersion}"
    const val ktorLogging = "io.ktor:ktor-client-logging:${Versions.ktorVersion}"
    const val ktorMock = "io.ktor:ktor-client-mock:${Versions.ktorVersion}"
    const val ktorOkhttp = "io.ktor:ktor-client-okhttp:${Versions.ktorVersion}"
    const val ktorSerialization = "io.ktor:ktor-client-serialization:${Versions.ktorVersion}"

    const val ktorSerializationKotlinxJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktorVersion}"

    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp3Version}"
    const val okhttp3Interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp3Version}"
    const val okhttp3MockWebserver = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp3Version}"

    const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chuckerVersion}"
    const val chuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:${Versions.chuckerVersion}"

    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
}