package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R

class NewsViewHolder(view: View) : ViewHolder(view) {

    val title by lazy { view.findViewById<TextView>(R.id.news_title) }
    val content by lazy { view.findViewById<TextView>(R.id.news_content) }

    fun SetupWith(new: NewsData) {
        title.text = new.newTitle
        content.text = new.newContent
    }
}