package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.components

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class AppBottomBar : Fragment(){

    companion object{
        private lateinit var Instance: AppBottomBar
        fun get() = Instance
    }
    lateinit var  bottomBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Instance=this
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.component_bottombar, container,false)
        bottomBar = view.findViewById(R.id.AppNavigationBottomBar)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomBar.setOnItemSelectedListener{ menuItem->
            AppToolBar.get().toolBar.title=menuItem.title

            if(menuItem.itemId != bottomBar.selectedItemId) {
                when (menuItem.itemId) {
                    R.id.news_bar_button -> {
                        when(bottomBar.selectedItemId){
                            R.id.cdl_button_bar_button->{
                                AppNavHost.get().navHost.navigate(R.id.transition_cdl_to_home)
                                Log.e("navigation","cdl to home")
                            }
                            R.id.community_button_bar_button->{
                                AppNavHost.get().navHost.navigate(R.id.transition_chat_to_home)
                                Log.e("navigation","chat to home")
                            }
                            R.id.stats_button_bar_button->{
                                AppNavHost.get().navHost.navigate(R.id.transition_stats_to_home)
                                Log.e("navigation","chat to home")
                            }
                        }
                    }

                    R.id.community_button_bar_button -> {
                        when(bottomBar.selectedItemId){
                            R.id.cdl_button_bar_button ->{
                                AppNavHost.get().navHost.navigate(R.id.transition_cdl_to_chat)
                                Log.e("navigation","cdl to chat")
                            }
                            R.id.news_bar_button ->{
                                AppNavHost.get().navHost.navigate(R.id.transition_home_to_chat)
                                Log.e("navigation","home to chat")
                            }
                            R.id.stats_button_bar_button->{
                                AppNavHost.get().navHost.navigate(R.id.transition_stats_to_chat)
                                Log.e("navigation","chat to home")
                            }
                        }
                    }
                    R.id.stats_button_bar_button -> {
                        when(bottomBar.selectedItemId){
                            R.id.news_bar_button ->{
                                AppNavHost.get().navHost.navigate(R.id.transition_home_to_stats)
                                Log.e("navigation","home to cdl")
                            }
                            R.id.community_button_bar_button ->{
                                AppNavHost.get().navHost.navigate(R.id.transition_chat_to_stats)
                                Log.e("navigation","chat to cdl")
                            }
                            R.id.cdl_button_bar_button->{
                                AppNavHost.get().navHost.navigate(R.id.transition_cdl_to_stats)
                                Log.e("navigation","chat to home")
                            }
                        }
                    }

                    R.id.cdl_button_bar_button -> {
                        when(bottomBar.selectedItemId){
                            R.id.news_bar_button ->{
                                AppNavHost.get().navHost.navigate(R.id.transition_home_to_cdl)
                                Log.e("navigation","home to cdl")
                            }
                            R.id.community_button_bar_button ->{
                                AppNavHost.get().navHost.navigate(R.id.transition_chat_to_cdl)
                                Log.e("navigation","chat to cdl")
                            }
                            R.id.stats_button_bar_button->{
                                AppNavHost.get().navHost.navigate(R.id.transition_stats_to_cdl)
                                Log.e("navigation","chat to home")
                            }
                        }
                    }
                }
            }

            true

        }
        bottomBar.selectedItemId=bottomBar.menu.getItem(0).itemId
    }
}