package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.Provider
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.UsersAdapter
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.repositories.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StatsScreen: Fragment() {

    lateinit var fragmentView: View

    lateinit var usersTable:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.stats_screen, container, false)
        return fragmentView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usersTable = view.findViewById(R.id.users_table)

        usersTable.layoutManager = LinearLayoutManager(requireContext())

        val repository = ApiService()

        val provider = Provider(repository)

        CoroutineScope(Dispatchers.IO).launch {
            val users = provider.GetAllUsers()

            CoroutineScope(Dispatchers.Main).launch {
                usersTable.adapter = UsersAdapter(users)
            }
        }
    }
}