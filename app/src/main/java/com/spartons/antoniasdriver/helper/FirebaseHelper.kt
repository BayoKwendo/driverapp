package com.spartons.antoniasdriver.helper

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.spartons.antoniasdriver.model.Driver

class FirebaseHelper(driverId: String) {

    companion object {
        private const val ONLINE_DRIVERS = "online_drivers"
    }

    private val onlineDriverDatabaseReference: DatabaseReference = FirebaseDatabase
            .getInstance()
            .reference
            .child(ONLINE_DRIVERS)
            .child(driverId)

    //    init {
    //        onlineDriverDatabaseReference
    //                .onDisconnect()
    //                .removeValue()
    //    }

    fun updateDriver(driver: Driver) {
        onlineDriverDatabaseReference.child("0000").setValue(driver)
        Log.e("Driver Info", " Updated")
    }

    fun deleteDriver() {
        onlineDriverDatabaseReference
                .removeValue()
    }
}