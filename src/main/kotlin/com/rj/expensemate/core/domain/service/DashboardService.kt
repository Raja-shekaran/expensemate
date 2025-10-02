package com.rj.expensemate.core.domain.service

import com.rj.expensemate.core.domain.model.Summary
import com.rj.expensemate.core.ports.`in`.DashboardUseCase
import com.rj.expensemate.core.ports.out.TransactionRepositoryPort
import com.rj.expensemate.util.Enums.TransactionType
import org.springframework.stereotype.Service
import java.util.*

@Service
class DashboardService(
    private val transactionRepository: TransactionRepositoryPort
) : DashboardUseCase {

    override fun getSummary(userId: UUID): Summary {
        val transactions = transactionRepository.findByUserId(userId)

        val totalIncome = transactions.filter { it.type == TransactionType.INCOME }.sumOf { it.amount }
        val totalExpense = transactions.filter { it.type == TransactionType.EXPENSE }.sumOf { it.amount }
        val balance = totalIncome - totalExpense

        return Summary(totalIncome, totalExpense, balance)
    }
}
