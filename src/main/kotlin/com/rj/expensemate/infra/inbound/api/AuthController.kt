package com.rj.expensemate.infra.inbound.api

import com.rj.expensemate.core.domain.service.AuthService
import com.rj.expensemate.infra.inbound.api.model.request.LoginRequest
import com.rj.expensemate.infra.inbound.api.model.request.SignupRequest
import com.rj.expensemate.infra.inbound.api.model.response.AuthResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(private val authService: AuthService) {

    @PostMapping("/signup")
    fun signup(@RequestBody request: SignupRequest): AuthResponse {
        return authService.signup(request)
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): AuthResponse {
        return authService.login(request)
    }
}