package com.rj.expensemate.infra.inbound.api.model.response

import java.util.UUID

data class CategoryResponse(
    val id: UUID,
    val userId: UUID,
    val name: String
)
