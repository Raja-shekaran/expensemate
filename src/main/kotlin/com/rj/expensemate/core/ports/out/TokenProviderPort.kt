package com.rj.expensemate.core.ports.out

import java.util.UUID

interface TokenProviderPort {
    fun generateToken(userId: UUID): String
}
