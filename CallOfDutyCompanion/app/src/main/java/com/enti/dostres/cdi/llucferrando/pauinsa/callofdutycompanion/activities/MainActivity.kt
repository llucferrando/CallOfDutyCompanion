package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.activities

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.R
import com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.firebaseclasses.FB
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    private val requestNotificationPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted->
        onNotificationPermissionResponse(isGranted)
    }
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)

        setContentView(R.layout.main_activity_screen)

        FB
            .crashalytics
            .logSingleError("Error2"){
                key("Name", "Lluc")
                key("IsSubnromal", true)
                key("Level Of Subnromality", 1900)
            }
        setTheme(FB.remoteConfig.getTheme().themeId)
        askNotificationPermission()
    }

    fun onNotificationPermissionResponse(isGranted:Boolean){
        if(isGranted){
             FirebaseMessaging.getInstance().token.addOnSuccessListener { token ->
                Log.d("Token","Token::> " + token)

            }.addOnFailureListener {
                //TODO ERROR
             }


        }else{
            //TODO ERROR
        }
    }

    fun askNotificationPermission(){
        val permission = Manifest.permission.POST_NOTIFICATIONS

        if(ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED){
            FirebaseMessaging.getInstance().token.addOnSuccessListener { token ->
                Log.d("Token","Token::> " + token)

            }.addOnFailureListener {
                //TODO ERROR
            }
        }else if(shouldShowRequestPermissionRationale(permission)){
            //Move to setup screen
        }else{
            requestNotificationPermissionLauncher.launch(permission)
        }


    }
}