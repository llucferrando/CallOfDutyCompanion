package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.firebase.ui.auth.data.model.User

class UsersAdapter(private val userList: List<UsersData>) : Adapter<UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UsersViewHolder(layoutInflater.inflate(R.layout.user_cell, parent, false))
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.SetupWith(userList[position])
    }

}