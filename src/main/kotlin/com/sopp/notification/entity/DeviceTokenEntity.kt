package com.sopp.notification.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "device-token")
data class DeviceTokenEntity(
    @Id
    val id: UUID=UUID.randomUUID(),
    val userId: String,
    var token: String
) {
    constructor() : this(UUID.randomUUID(), "", "")
}
