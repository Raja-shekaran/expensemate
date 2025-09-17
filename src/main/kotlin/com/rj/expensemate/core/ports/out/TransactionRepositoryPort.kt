package com.rj.expensemate.core.ports.out

import com.rj.expensemate.core.domain.model.Transaction
import java.util.*

interface TransactionRepositoryPort {
    fun save(transaction: Transaction): Transaction
    fun findByUserId(userId: UUID): List<Transaction>
    fun deleteById(transactionId: UUID)
}
