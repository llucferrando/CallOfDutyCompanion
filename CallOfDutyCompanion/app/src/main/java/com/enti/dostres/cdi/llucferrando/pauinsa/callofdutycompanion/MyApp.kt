package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion

import android.app.Application
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.firebaseclasses.FB

class MyApp : Application(){
    companion object{
        private lateinit var  instance: MyApp
        fun get()= instance

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        FB.init(this)
        FB.analytics.logOpenApp()
    }



}