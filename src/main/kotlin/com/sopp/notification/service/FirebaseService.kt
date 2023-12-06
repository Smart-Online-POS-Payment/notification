package com.sopp.notification.service

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import org.springframework.stereotype.Service

@Service
class FirebaseService(
    private val firebaseMessaging: FirebaseMessaging,
) {

    fun sendNotification(token: String){
        println(token)
        val message = Message.builder().setToken(token).putData("title","Deneme").putData("body", "deneme")
            .build()
        firebaseMessaging.send(message)
    }
}