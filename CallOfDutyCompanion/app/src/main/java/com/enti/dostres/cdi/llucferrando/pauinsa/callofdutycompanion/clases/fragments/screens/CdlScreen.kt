package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.screens

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.firebase.ui.auth.AuthUI.getApplicationContext
import com.google.android.material.imageview.ShapeableImageView

class CdlScreen: Fragment()
{
    lateinit var fragmentView: View

    val cdlTeams by lazy { fragmentView.findViewById<LinearLayout>(R.id.cdl_screen) }

    val atlfaze by lazy { fragmentView.findViewById<ShapeableImageView>(R.id.atlantafaze_cdl) }
    val bstnbreach by lazy { fragmentView.findViewById<ShapeableImageView>(R.id.bostonbreach_cdl) }
    val roylravens by lazy { fragmentView.findViewById<ShapeableImageView>(R.id.royalravens_cdl) }
    val seattlesurge by lazy { fragmentView.findViewById<ShapeableImageView>(R.id.seattlesurge_cdl) }
    val nysubliners by lazy { fragmentView.findViewById<ShapeableImageView>(R.id.nysubliners_cdl) }
    val lathieves by lazy { fragmentView.findViewById<ShapeableImageView>(R.id.lathieves_cdl) }
    val miamiheretics by lazy { fragmentView.findViewById<ShapeableImageView>(R.id.miamiheretics_cdl) }
    val optictexas by lazy { fragmentView.findViewById<ShapeableImageView>(R.id.optictexas_cdl) }
    val aglguerrillas by lazy { fragmentView.findViewById<ShapeableImageView>(R.id.angelesguerrillas_cdl) }
    val minnesotarokkr by lazy { fragmentView.findViewById<ShapeableImageView>(R.id.minnestotarokkr_cdl) }
    val torontoUltra by lazy { fragmentView.findViewById<ShapeableImageView>(R.id.torontoultra_cdl) }
    val vegaslegion by lazy { fragmentView.findViewById<ShapeableImageView>(R.id.vegaslegion_cdl) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.cdl_screen, container,false)
        return fragmentView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickCDLTeam()
    }
    private fun clickCDLTeam()
    {
        atlfaze.setOnClickListener {  goToUrl("https://faze.callofdutyleague.com/en-us/") }
        bstnbreach.setOnClickListener { goToUrl("https://breach.callofdutyleague.com/en-us/") }
        roylravens.setOnClickListener { goToUrl("https://ravens.callofdutyleague.com/en-us/") }
        seattlesurge.setOnClickListener { goToUrl("https://surge.callofdutyleague.com/en-us/") }
        nysubliners.setOnClickListener { goToUrl("https://subliners.callofdutyleague.com/en-us/") }
        lathieves.setOnClickListener { goToUrl("https://thieves.callofdutyleague.com/en-us/") }
        miamiheretics.setOnClickListener { goToUrl("https://heretics.callofdutyleague.com/en-us/") }
        optictexas.setOnClickListener { goToUrl("https://optic.callofdutyleague.com/en-us/") }
        aglguerrillas.setOnClickListener { goToUrl("https://guerrillas.callofdutyleague.com/en-us/") }
        minnesotarokkr.setOnClickListener { goToUrl("https://rokkr.callofdutyleague.com/en-us/") }
        torontoUltra.setOnClickListener { goToUrl("https://ultra.callofdutyleague.com/en-us/") }
            vegaslegion.setOnClickListener { goToUrl("https://legion.callofdutyleague.com/en-us/") }

    }
    private fun goToUrl(string :String){
        val urlIntent = Intent(android.content.Intent.ACTION_VIEW)
        urlIntent.data=Uri.parse(string)
        startActivity(urlIntent);
    }

}
