package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.firebaseclasses

import com.google.firebase.Firebase
import com.google.firebase.crashlytics.KeyValueBuilder
import com.google.firebase.crashlytics.crashlytics
import java.lang.Exception

class MyCrashalytics {
    private val crashalytics = Firebase.crashlytics

    fun logSingleError(text: String, addExtraDataLambda: (KeyValueBuilder.() -> Unit)? = null){
        logError(Exception(text), addExtraDataLambda)
    }

    fun logError(exception: Exception, addExtraDataLambda: (KeyValueBuilder.() -> Unit)? = null)
    {

        addExtraDataLambda?.let {lambda ->
            val builder = KeyValueBuilder(crashalytics)
            builder.lambda()
        }


        crashalytics.recordException(exception)

    }
}