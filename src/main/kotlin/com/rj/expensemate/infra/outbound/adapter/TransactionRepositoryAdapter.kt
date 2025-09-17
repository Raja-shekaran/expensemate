package com.rj.expensemate.infra.outbound.adapter

import com.rj.expensemate.core.domain.model.Transaction
import com.rj.expensemate.core.ports.out.TransactionRepositoryPort
import com.rj.expensemate.infra.outbound.entity.TransactionEntity
import com.rj.expensemate.infra.outbound.repository.SpringDataTransactionRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class TransactionRepositoryAdapter(
    private val springRepo: SpringDataTransactionRepository
) : TransactionRepositoryPort {

    override fun save(transaction: Transaction): Transaction {
        val entity = TransactionEntity(
            id = transaction.id,
            userId = transaction.userId,
            amount = transaction.amount,
            type = transaction.type,
            categoryId = transaction.categoryId,
            date = transaction.date,
            notes = transaction.notes
        )
        springRepo.save(entity)
        return transaction
    }

    override fun findByUserId(userId: UUID): List<Transaction> {
        return springRepo.findByUserId(userId).map {
            Transaction(
                id = it.id,
                userId = it.userId,
                amount = it.amount,
                type = it.type,
                categoryId = it.categoryId,
                date = it.date,
                notes = it.notes
            )
        }
    }

    override fun deleteById(transactionId: UUID) {
        springRepo.deleteById(transactionId)
    }
}
