package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputLayout

class ContactUs : Fragment(){
    lateinit var fragmentView: View
    val contactPhone by lazy { fragmentView.findViewById<MaterialCardView>(R.id.phoneContact) }
    val contactMail by lazy { fragmentView.findViewById<TextInputLayout>(R.id.emailContact) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.contactus_screen, container,false)
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contactPhone.setOnClickListener { contactUsByPhone() }
        contactMail.setOnClickListener { contactUsByMail() }
    }
    private fun contactUsByPhone(){
        contactPhone.setOnClickListener {

        }

    }
    private fun contactUsByMail(){
        contactMail.setOnClickListener {

        }

    }

}