package kr.ac.tu.capstone.capstone

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

class MyFirebaseInstanceIDService : FirebaseInstanceIdService() {
    override fun onTokenRefresh() {
        val refreshedToken = FirebaseInstanceId.getInstance().token
        println("Refreshed token: " + refreshedToken!!)

        // To Do Develop Code, example sending token
    }
}