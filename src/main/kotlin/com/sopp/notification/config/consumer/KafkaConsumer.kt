package com.sopp.notification.config.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.sopp.notification.model.KafkaPaymentModel
import com.sopp.notification.service.NotificationService
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaConsumer(
    private val notificationService: NotificationService
) {
    private val logger = LoggerFactory.getLogger(this.javaClass)
    private val objectMapper = ObjectMapper().apply {
        registerKotlinModule()
    }
    @KafkaListener(topics = ["payment"], groupId = "group")
    fun firstListener(message: String) {
        logger.info("Message received: [$message]")
        try {
            val paymentModel = objectMapper.readValue(message, KafkaPaymentModel::class.java)
            logger.info("Message received: [$paymentModel]")
            notificationService.sendNotification(paymentModel)
        } catch (e: Exception) {
            logger.error("Error deserializing message: $message", e)
        }
    }
}