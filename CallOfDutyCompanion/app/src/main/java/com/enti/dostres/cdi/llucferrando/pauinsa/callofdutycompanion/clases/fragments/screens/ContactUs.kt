package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.screens

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.google.android.material.button.MaterialButton


class ContactUs : Fragment(){
    lateinit var fragmentView: View
    val contactPhone by lazy { fragmentView.findViewById<MaterialButton>(R.id.phoneContact) }
    val contactMail by lazy { fragmentView.findViewById<MaterialButton>(R.id.emailContact) }
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
        val phoneIntent = Intent(Intent.ACTION_DIAL)
        phoneIntent.setData(Uri.parse("tel:609969448"))
        startActivity(phoneIntent)

    }
    private fun contactUsByMail(){
        val emailIntent = Intent(Intent.ACTION_SENDTO,
            Uri.fromParts("mailto","lluc.ferrando@enti.cat",null))
            startActivity(Intent.createChooser(emailIntent, "Send email"))

    }

}