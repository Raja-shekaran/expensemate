package com.rj.expensemate.core.ports.`in`

import com.rj.expensemate.core.domain.model.Transaction
import java.util.*

interface TransactionUseCase {
    fun addTransaction(transaction: Transaction): Transaction
    fun getTransactions(userId: UUID): List<Transaction>
    fun deleteTransaction(transactionId: UUID)
}

