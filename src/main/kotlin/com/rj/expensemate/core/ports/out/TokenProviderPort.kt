package com.rj.expensemate.core.ports.out

interface TokenProviderPort {
    fun generateToken(email: String): String
}
