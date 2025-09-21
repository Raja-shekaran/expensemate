package com.rj.expensemate.infra.inbound.api.model.request

import com.rj.expensemate.util.Enums.TransactionType
import java.util.*

data class TransactionRequest(
    val amount: Double,
    val type: TransactionType,
    val categoryId: UUID?,
    val date: Date,
    val notes: String?
)
