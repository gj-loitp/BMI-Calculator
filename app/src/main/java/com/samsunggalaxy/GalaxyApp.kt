package com.samsunggalaxy

import android.app.Application
import com.google.android.material.color.DynamicColors

//TODO firebase
//TODO applovin ad

//TODO keep value cuoi cung de hien thi len wheel view
//TODO change color
//TODO ic launcher
//TODO rate app
//TODO more app
//TODO share app
//TODO policy
//TODO leak canary
//TODO keystore

//done mckimquyen
//ad id manifest
class GalaxyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}