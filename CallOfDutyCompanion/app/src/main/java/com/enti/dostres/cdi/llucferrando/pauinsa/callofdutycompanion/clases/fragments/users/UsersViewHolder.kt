package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R

class UsersViewHolder(view: View) : ViewHolder(view) {

    val name by lazy { view.findViewById<TextView>(R.id.user_id) }
    val stat1 by lazy { view.findViewById<TextView>(R.id.user_first_stat) }

    fun SetupWith(user: UsersData) {
        name.text = user.userName
        stat1.text = user.description
    }
}