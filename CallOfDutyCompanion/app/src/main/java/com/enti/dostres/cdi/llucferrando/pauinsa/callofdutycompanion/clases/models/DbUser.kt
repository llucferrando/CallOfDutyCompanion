package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.models

import java.util.Date

data class DbUser(
    override var id: String?= null,
    var email: String? = null,
    var username: String?= null,
    var photoPath: String?= null,
    var lastlogin: Date?= null,
    var admin: Boolean = false
):DbBaseData {
    override fun getTable() = "Users"
}
