package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.models

interface DbBaseData {
    var id:String?
    fun getTable(): String
}