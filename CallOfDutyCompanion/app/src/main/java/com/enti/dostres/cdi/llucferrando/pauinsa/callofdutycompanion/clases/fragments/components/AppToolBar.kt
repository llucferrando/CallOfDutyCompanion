package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.firebaseclasses.FB
import com.google.android.material.appbar.MaterialToolbar
import io.grpc.Context.key

class AppToolBar: Fragment() {
    companion object{
        private lateinit var Instance: AppToolBar
        fun get() = Instance
    }

    lateinit var  toolBar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Instance =this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.component_toolbar, container, false)
        toolBar= view.findViewById(R.id.AppToolBar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBar.setNavigationOnClickListener{
            AppDrawer.get().openDrawer()
        }
        toolBar.setOnMenuItemClickListener{ menuItem->
            when(menuItem.itemId){
                R.id.toolbar_button_test->{
                    //throw RuntimeException("Test Crash") // Force a crash
                    //val exception = Exception("Test Error")
                    FB.crashalytics.logSingleError("Error"){
                        key("Name", "Lluc")
                        key("IsSubnromal", true)
                        key("Level Of Subnromality", 1900)

                    }
                }

            }
            true
        }
    }

}