package com.sopp.notification.service

import com.sopp.notification.entity.DeviceTokenEntity
import com.sopp.notification.repository.DeviceTokenRepository
import org.springframework.stereotype.Service

@Service
class RegistrationTokenService(
    private val deviceTokenRepository: DeviceTokenRepository
) {

    fun setToken(userId: String, token: String) {
        deviceTokenRepository.findByUserId(userId).ifPresentOrElse(
            { tokenEntity -> tokenEntity.token = token; deviceTokenRepository.save(tokenEntity) },
            { deviceTokenRepository.save(DeviceTokenEntity(userId = userId, token = token)) }
        )
    }

    fun getToken(userId: String): String {
        return deviceTokenRepository.findByUserId(userId).get().token
    }
}