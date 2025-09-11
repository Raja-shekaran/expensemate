package com.rj.expensemate.infra.inbound.api.model.request

data class SignupRequest(val name: String, val email: String, val password: String)
