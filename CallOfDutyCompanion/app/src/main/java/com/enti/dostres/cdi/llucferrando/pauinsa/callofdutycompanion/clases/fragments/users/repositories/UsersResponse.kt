package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.repositories

import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.UsersData
import com.google.gson.annotations.SerializedName

data class CharactersResponse(val code: Int, @SerializedName("data") val charactersData: CharactersResponseData)

data class CharactersResponseData(val offset: Int, val count: Int, val total: Int, @SerializedName("results") val usersList: MutableList<UsersData>)
