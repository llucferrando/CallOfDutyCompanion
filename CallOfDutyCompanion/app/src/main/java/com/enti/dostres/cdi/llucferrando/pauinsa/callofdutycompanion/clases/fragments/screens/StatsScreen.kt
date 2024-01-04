package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.UsersAdapter
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.UsersProvider
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.repositories.UsersApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StatsScreen: ComponentActivity() {

    val table by lazy { findViewById<RecyclerView>(R.id.users_table) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stats_screen)

        table.layoutManager = LinearLayoutManager(this)

        //val repository = HeroMockRepository()
        //val repository = HeroSharedDatabase()
        val repository = UsersApiService()

        val provider = UsersProvider(repository)

        CoroutineScope(Dispatchers.IO).launch {
            val users = provider.GetAllUsers()

            CoroutineScope(Dispatchers.Main).launch {
                table.adapter = UsersAdapter(users)
            }
        }
    }
}