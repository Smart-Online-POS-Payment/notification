package com.sopp.notification.controller

import com.sopp.notification.service.RegistrationTokenService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/token")
class RegistrationTokenController(
    private val registrationTokenService: RegistrationTokenService
) {

    @PostMapping("{token}/user/{userId}")
    fun setToken(@PathVariable token: String, @PathVariable userId: String){
        registrationTokenService.setToken(userId, token)
    }
}