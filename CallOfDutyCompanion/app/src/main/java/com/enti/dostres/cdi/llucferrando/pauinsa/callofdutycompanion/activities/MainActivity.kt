package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.firebaseclasses.FB
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.NewsAdapter
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.Provider
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.UsersAdapter
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.repositories.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : FragmentActivity() {

    val usersTable by lazy { findViewById<RecyclerView>(R.id.users_table) }
    val newsTable by lazy { findViewById<RecyclerView>(R.id.news_table) }
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)

        setContentView(R.layout.main_activity_screen)

        usersTable.layoutManager = LinearLayoutManager(this)
        newsTable.layoutManager = LinearLayoutManager(this)

        val repository = ApiService()

        val provider = Provider(repository)

        CoroutineScope(Dispatchers.IO).launch {
            val users = provider.GetAllUsers()

            CoroutineScope(Dispatchers.Main).launch {
                usersTable.adapter = UsersAdapter(users)
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            val news = provider.GetAllNews()

            CoroutineScope(Dispatchers.Main).launch {
                newsTable.adapter = NewsAdapter(news)
            }
        }

        /*FB
            .crashalytics
            .logSingleError("Error2"){
                key("Name", "Lluc")
                key("IsSubnromal", true)
                key("Level Of Subnromality", 1900)
            }
        setTheme(FB.remoteConfig.getTheme().themeId)*/
    }




}