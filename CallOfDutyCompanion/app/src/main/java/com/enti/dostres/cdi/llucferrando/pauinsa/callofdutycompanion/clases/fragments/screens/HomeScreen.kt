package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R

class HomeScreen: Fragment() {

    lateinit var fragmentView: View
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {

            fragmentView = inflater.inflate(R.layout.screen_home, container, false)
            return fragmentView
        }
}