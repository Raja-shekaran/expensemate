package com.rj.expensemate.infra.inbound.api.model.request

import java.util.*

data class CategoryRequest(
    val userId: UUID,
    val name: String
)
