package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users

import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.repositories.Repository

class Provider(val repository: Repository) {
    suspend fun GetAllUsers() : MutableList<UsersData> {
        return repository.GetUsers()
    }

    suspend fun GetAllNews() : MutableList<NewsData> {
        return repository.GetNews()
    }

}