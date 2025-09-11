package com.rj.expensemate.infra.outbound.entity

import com.rj.expensemate.core.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID> {
    fun findByEmail(email: String): User?
}