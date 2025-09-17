package com.rj.expensemate.core.domain.model

import java.util.*

data class User(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val email: String,
    val passwordHash: String?,
    val provider: String = "LOCAL",
    val providerId: String? = null,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)
