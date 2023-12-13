package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.firebaseclasses

import android.app.Application
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class MyFirebaseAnalytics (val appContext: Application) {
    private val analytics = FirebaseAnalytics.getInstance(appContext)

    fun logOpenApp(){
        val bundle = Bundle()
        analytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, bundle)
    }
}