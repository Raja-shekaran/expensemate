package com.rj.expensemate.core.ports.`in`

import com.rj.expensemate.infra.inbound.api.model.request.LoginRequest
import com.rj.expensemate.infra.inbound.api.model.request.SignupRequest
import com.rj.expensemate.infra.inbound.api.model.response.AuthResponse

interface AuthUseCase {
    fun signup(request: SignupRequest): AuthResponse
    fun login(request: LoginRequest): AuthResponse
}
