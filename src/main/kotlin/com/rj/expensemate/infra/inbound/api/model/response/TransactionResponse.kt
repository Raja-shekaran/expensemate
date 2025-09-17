package com.rj.expensemate.infra.inbound.api.model.response

import com.rj.expensemate.util.Enums
import java.util.*

data class TransactionResponse(
    val id: UUID,
    val userId: UUID,
    val amount: Double,
    val type: Enums.TransactionType,
    val categoryId: UUID?,
    val date: Date,
    val notes: String?
)