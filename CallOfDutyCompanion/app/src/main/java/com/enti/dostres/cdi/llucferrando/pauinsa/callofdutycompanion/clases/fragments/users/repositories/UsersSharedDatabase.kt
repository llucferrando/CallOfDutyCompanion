package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.repositories

import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.Utils.Shared
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.NewsData
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.UsersData

class UsersSharedDatabase : Repository {
    override suspend fun GetUsers(): MutableList<UsersData> {
        return Shared.Users
    }

    override suspend fun GetNews(): MutableList<NewsData> {
        return Shared.News
    }
}