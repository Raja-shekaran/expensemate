package com.rj.expensemate.infra.outbound.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "categories", schema = "expensemate")
data class CategoryEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val userId: UUID,

    @Column(nullable = false)
    val name: String
)
