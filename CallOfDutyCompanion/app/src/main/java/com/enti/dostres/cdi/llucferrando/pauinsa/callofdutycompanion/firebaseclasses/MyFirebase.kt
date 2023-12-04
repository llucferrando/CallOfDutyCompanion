package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.firebaseclasses

import android.app.Application

typealias FB = MyFirebase
class MyFirebase {
    companion object{
        lateinit var analytics: MyFirebaseAnalytics
        val crashalytics = MyCrashalytics()
        fun init(appContext:Application){

            analytics = MyFirebaseAnalytics(appContext)

        }
    }
}