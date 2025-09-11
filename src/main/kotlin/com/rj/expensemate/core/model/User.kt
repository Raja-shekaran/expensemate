package com.rj.expensemate.core.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "users", schema = "expensemate")
data class User(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false, unique = true)
    var email: String,

    var passwordHash: String? = null,

    var provider: String = "LOCAL",

    var providerId: String? = null,

    @Column(name = "created_at")
    var createdAt: Date = Date(),

    @Column(name = "updated_at")
    var updatedAt: Date = Date()
)
