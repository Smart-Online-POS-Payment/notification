package com.sopp.notification.service

import com.sopp.notification.model.KafkaPaymentModel
import com.sopp.notification.repository.DeviceTokenRepository
import org.springframework.stereotype.Service

@Service
class NotificationService(
    private val firebaseService: FirebaseService,
    private val registrationTokenService: RegistrationTokenService
) {
    fun sendNotification(paymentModel: KafkaPaymentModel){
        val merchantToken= registrationTokenService.getToken(paymentModel.merchantId)
        val customerToken= registrationTokenService.getToken(paymentModel.customerId)
        firebaseService.sendNotification(merchantToken)
        firebaseService.sendNotification(customerToken)
    }
}