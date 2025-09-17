package com.rj.expensemate.infra.outbound.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "users", schema = "expensemate")
data class UserEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false, unique = true)
    var email: String,

    @Column(name = "password_hash")
    var passwordHash: String? = null,

    var provider: String = "LOCAL",

    @Column(name = "provider_id")
    var providerId: String? = null,

    @Column(name = "created_at")
    var createdAt: Date = Date(),

    @Column(name = "updated_at")
    var updatedAt: Date = Date()
)
