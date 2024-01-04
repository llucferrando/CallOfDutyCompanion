package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users

import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.fragments.users.repositories.UsersRepository

class UsersProvider(val repository: UsersRepository) {
    suspend fun GetAllUsers() : MutableList<UsersData> {
        return repository.GetUsers()
    }

}