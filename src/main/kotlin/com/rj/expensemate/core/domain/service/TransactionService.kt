package com.rj.expensemate.core.domain.service

import com.rj.expensemate.core.domain.model.Transaction
import com.rj.expensemate.core.ports.`in`.TransactionUseCase
import com.rj.expensemate.core.ports.out.TransactionRepositoryPort
import org.springframework.stereotype.Service
import java.util.*

@Service
class TransactionService(
    private val transactionRepository: TransactionRepositoryPort
) : TransactionUseCase {

    override fun addTransaction(transaction: Transaction): Transaction {
        return transactionRepository.save(transaction)
    }

    override fun getTransactions(userId: UUID): List<Transaction> {
        return transactionRepository.findByUserId(userId)
    }

    override fun deleteTransaction(transactionId: UUID) {
        transactionRepository.deleteById(transactionId)
    }
}

