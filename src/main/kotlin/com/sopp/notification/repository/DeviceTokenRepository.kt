package com.sopp.notification.repository

import com.sopp.notification.entity.DeviceTokenEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface  DeviceTokenRepository: CrudRepository<DeviceTokenEntity, UUID> {
    fun findByUserId(userId: String): Optional<DeviceTokenEntity>
}