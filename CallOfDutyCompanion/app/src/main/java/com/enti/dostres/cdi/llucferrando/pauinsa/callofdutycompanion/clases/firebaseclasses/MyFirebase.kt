package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.firebaseclasses

import android.app.Application

typealias FB = MyFirebase
class MyFirebase {
    companion object{
        lateinit var analytics: MyFirebaseAnalytics
        lateinit var authentication: MyFirebaseAuthentication
        val crashalytics = MyCrashalytics()
        val db = MyFirebaseDatabase()
        fun init(appContext: Application){
            authentication = MyFirebaseAuthentication(appContext)
            analytics = MyFirebaseAnalytics(appContext)

        }

    }
}