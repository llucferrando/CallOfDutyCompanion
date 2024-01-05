package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.repositories

import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.NewsData
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.UsersData
import com.google.gson.annotations.SerializedName

data class NewsResponse(val code: Int, @SerializedName("data") val newsData: NewsResponseData)

data class NewsResponseData(val offset: Int, val count: Int, val total: Int, @SerializedName("results") val newsList: MutableList<NewsData>)
