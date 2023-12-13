package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.firebaseclasses.FB

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_screen)

        FB
            .crashalytics
            .logSingleError("Error2"){
                key("Name", "Lluc")
                key("IsSubnromal", true)
                key("Level Of Subnromality", 1900)
            }
    }

}