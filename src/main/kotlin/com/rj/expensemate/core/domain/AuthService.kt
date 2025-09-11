package com.rj.expensemate.core.domain

import com.rj.expensemate.core.model.User
import com.rj.expensemate.infra.inbound.api.model.request.LoginRequest
import com.rj.expensemate.infra.inbound.api.model.request.SignupRequest
import com.rj.expensemate.infra.inbound.api.model.response.AuthResponse
import com.rj.expensemate.infra.outbound.entity.UserRepository
import com.rj.expensemate.util.JwtUtil
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JwtUtil
) {
    fun signup(request: SignupRequest): AuthResponse {
        if (userRepository.findByEmail(request.email) != null) {
            throw IllegalArgumentException("Email already registered")
        }

        val user = User(
            name = request.name,
            email = request.email,
            passwordHash = passwordEncoder.encode(request.password),
            provider = "LOCAL"
        )
        userRepository.save(user)

        val token = jwtUtil.generateToken(user.email)
        return AuthResponse(token)
    }

    fun login(request: LoginRequest): AuthResponse {
        val user = userRepository.findByEmail(request.email)
            ?: throw IllegalArgumentException("Invalid email or password")

        if (user.passwordHash == null || !passwordEncoder.matches(request.password, user.passwordHash)) {
            throw IllegalArgumentException("Invalid email or password")
        }

        val token = jwtUtil.generateToken(user.email)
        return AuthResponse(token)
    }
}
