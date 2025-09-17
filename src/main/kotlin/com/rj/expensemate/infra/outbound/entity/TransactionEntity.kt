package com.rj.expensemate.infra.outbound.entity

import com.rj.expensemate.util.Enums.TransactionType
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "transactions", schema = "expensemate")
data class TransactionEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val userId: UUID,

    @Column(nullable = false)
    val amount: Double,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val type: TransactionType,

    val categoryId: UUID? = null,

    @Column(nullable = false)
    val date: Date,

    val notes: String? = null
)
