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

class CdlScreen: Fragment() {
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
        clickCDLTeam()
    }
    private fun clickCDLTeam(){
        atlfaze.setOnClickListener {  //goToUrl() }
        bstnbreach.setOnClickListener { //goToUrl() }
        roylravens.setOnClickListener { //goToUrl() }
        seattlesurge.setOnClickListener { //goToUrl() }
        nysubliners.setOnClickListener { //goToUrl() }
        lathieves.setOnClickListener { //goToUrl() }
        miamiheretics.setOnClickListener { //goToUrl() }
        optictexas.setOnClickListener { //goToUrl() }
        aglguerrillas.setOnClickListener { //goToUrl() }
        minnesotarokkr.setOnClickListener { //goToUrl() }
        torontoUltra.setOnClickListener { //goToUrl() }
        vegaslegion.setOnClickListener { //goToUrl() }

    }
    /*private void goToUrl(string s){
        try{
            Uri uri = Uri.parse(s);
            startActivity(new Intent(Intent.ACTION_VIEW,uri));
        }

        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Error 404",Toast.LENGTH_SHORT).show();
        }

    }*/
}