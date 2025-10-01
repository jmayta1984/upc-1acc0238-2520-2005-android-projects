import shadow.bundletool.com.android.tools.r8.internal.li

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    alias(libs.plugins.ksp) apply false // ksp
    alias(libs.plugins.hilt) apply false // Hilt
}