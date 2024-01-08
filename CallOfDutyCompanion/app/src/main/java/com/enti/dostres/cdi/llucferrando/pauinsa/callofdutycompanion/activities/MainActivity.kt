package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.activities

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.MyApp
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.MyApp.Companion.Context
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.firebaseclasses.FB
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.NewsAdapter
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.Provider
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.UsersAdapter
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.repositories.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    val newsTable by lazy { findViewById<RecyclerView>(R.id.news_table) }
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        setContentView(R.layout.main_activity_screen)



        FB
            .crashalytics
            .logSingleError("Error2"){
                key("Name", "Lluc")
                key("IsSubnromal", true)
                key("Level Of Subnromality", 1900)
            }
        setTheme(FB.remoteConfig.getTheme().themeId)
    }




}