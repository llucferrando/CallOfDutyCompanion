package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.firebaseclasses

import android.app.Application
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.models.DbUser
import com.google.firebase.auth.FirebaseAuth

class MyFirebaseAuthentication(val appContext: Application) {
    private val firebaseAuthentication = FirebaseAuth.getInstance()
    private var currentUser: DbUser?= null

    fun isLoginActive() = getUser() != null
    fun getUser() = currentUser
    fun setCurrentUser(newUser:DbUser){
        currentUser = newUser
    }
    fun getAuthDbUser() : DbUser? {

        firebaseAuthentication.currentUser?.let { user ->
            val dbUser = DbUser(
                id = user.uid,
                email = user.email,
                username = user.displayName,
                photoPath = user.photoUrl.toString()
            )
            return dbUser
        }

        return null
    }
}