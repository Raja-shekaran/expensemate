package com.rj.expensemate.infra.outbound.repository

import com.rj.expensemate.infra.outbound.entity.TransactionEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SpringDataTransactionRepository : JpaRepository<TransactionEntity, UUID> {
    fun findByUserId(userId: UUID): List<TransactionEntity>
}
