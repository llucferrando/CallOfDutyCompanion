package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users

import android.os.Build
import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R

class NewsViewHolder(view: View) : ViewHolder(view) {

    val title by lazy { view.findViewById<TextView>(R.id.news_title) }
    val content by lazy { view.findViewById<TextView>(R.id.news_content) }


     fun SetupWith(new: NewsData) {
        title.text = new.title
         content.text = Html.fromHtml(new.contents).toString()

        println("HOLA")
        println(new.title)
        println(new.contents)
    }
}