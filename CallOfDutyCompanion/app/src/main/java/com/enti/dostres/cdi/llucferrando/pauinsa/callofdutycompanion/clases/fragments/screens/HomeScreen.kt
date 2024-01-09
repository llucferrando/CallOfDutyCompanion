package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.NewsAdapter
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.Provider
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.repositories.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeScreen: Fragment() {

    lateinit var fragmentView: View

    lateinit var newsTable: RecyclerView
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            fragmentView = inflater.inflate(R.layout.screen_home, container, false)
            return fragmentView
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsTable = view.findViewById(R.id.news_table)

        newsTable.layoutManager = LinearLayoutManager(requireContext())

        val repository = ApiService()

        val provider = Provider(repository)

        CoroutineScope(Dispatchers.IO).launch {
            val news = provider.GetAllNews()

            CoroutineScope(Dispatchers.Main).launch {
                newsTable.adapter = NewsAdapter(news)
            }
        }


    }
}