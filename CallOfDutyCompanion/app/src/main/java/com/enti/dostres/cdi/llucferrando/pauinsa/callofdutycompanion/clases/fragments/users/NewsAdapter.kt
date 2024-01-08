package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.firebase.ui.auth.data.model.User

class NewsAdapter(private val newsList: List<NewsData>) : Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(layoutInflater.inflate(R.layout.new_cell, parent, false))
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.SetupWith(newsList[position])
    }

}