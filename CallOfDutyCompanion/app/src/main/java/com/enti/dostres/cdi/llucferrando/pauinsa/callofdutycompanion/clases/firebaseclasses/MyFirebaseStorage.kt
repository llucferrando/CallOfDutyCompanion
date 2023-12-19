package com.enti.dostres.cdi.llucferrando.pauinsa.callofdutycompanion.clases.firebaseclasses

import android.net.Uri
import com.google.firebase.Firebase
import com.google.firebase.storage.storage
import java.lang.Exception
import java.nio.file.FileSystems
import java.nio.file.Path

class MyFirebaseStorage {
    private val storage = Firebase.storage
    private val storageRootRef=storage.reference

    private val imagesPath = "Images"
    private val imagesRef = storageRootRef.child(imagesPath)

    fun saveImage(uri: Uri, onSuccess: (Uri)->Unit, onFailure: (Exception)->Unit){

        val path: Path = FileSystems.getDefault().getPath(uri.path)
        val name = path.fileName.toString()

        val imageRef = imagesRef.child(name)
        imageRef.putFile(uri).addOnSuccessListener {
                uploadSnapshot->uploadSnapshot.storage.downloadUrl
            .addOnSuccessListener(onSuccess)
            .addOnFailureListener(onFailure)
        }
            .addOnFailureListener(onFailure)


    }

}