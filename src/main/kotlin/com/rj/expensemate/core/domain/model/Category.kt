package com.rj.expensemate.core.domain.model

import java.util.UUID

data class Category(
    val id: UUID,
    val userId: UUID,
    val name: String
)