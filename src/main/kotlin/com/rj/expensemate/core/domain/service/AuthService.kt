package com.rj.expensemate.core.domain.service

import com.rj.expensemate.core.domain.model.User
import com.rj.expensemate.core.ports.`in`.AuthUseCase
import com.rj.expensemate.core.ports.out.PasswordEncoderPort
import com.rj.expensemate.core.ports.out.TokenProviderPort
import com.rj.expensemate.core.ports.out.UserRepositoryPort
import com.rj.expensemate.infra.inbound.api.model.request.LoginRequest
import com.rj.expensemate.infra.inbound.api.model.request.SignupRequest
import com.rj.expensemate.infra.inbound.api.model.response.AuthResponse
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepositoryPort,
    private val passwordEncoder: PasswordEncoderPort,
    private val tokenProvider: TokenProviderPort
) : AuthUseCase {

    override fun signup(request: SignupRequest): AuthResponse {
        if (userRepository.findByEmail(request.email) != null) {
            throw IllegalArgumentException("Email already registered")
        }

        val user = User(
            name = request.name,
            email = request.email,
            passwordHash = passwordEncoder.encode(request.password),
            provider = "LOCAL"
        )

        val savedUser = userRepository.save(user)

        val token = tokenProvider.generateToken(savedUser.id)
        return AuthResponse(token)
    }

    override fun login(request: LoginRequest): AuthResponse {
        val user = userRepository.findByEmail(request.email)
            ?: throw IllegalArgumentException("Invalid email or password")

        if (user.passwordHash == null || !passwordEncoder.matches(request.password, user.passwordHash)) {
            throw IllegalArgumentException("Invalid email or password")
        }

        val token = tokenProvider.generateToken(user.id)
        return AuthResponse(token)
    }
}