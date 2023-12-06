package com.sopp.notification.model

import java.math.BigDecimal

data class KafkaPaymentModel(
    val customerId: String,
    val merchantId: String,
    val amount: BigDecimal,
    val paymentMessage: String
)
