package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.repositories

import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.NewsData
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.UsersData
import com.google.gson.annotations.SerializedName

data class NewsResponse(val code: Int, @SerializedName("newsitems") val newsData: NewsResponseData)

data class NewsResponseData( val count: Int, @SerializedName("appnews") val newsList: MutableList<NewsData>)
