package com.rj.expensemate.core.domain.model

import com.rj.expensemate.util.Enums.TransactionType
import java.util.*

data class Transaction(
    val id: UUID = UUID.randomUUID(),
    val userId: UUID,
    val amount: Double,
    val type: TransactionType,
    val categoryId: UUID?,
    val date: Date,
    val notes: String?
)
